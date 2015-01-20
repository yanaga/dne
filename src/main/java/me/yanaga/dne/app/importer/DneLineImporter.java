package me.yanaga.dne.app.importer;

import com.mysema.query.sql.Configuration;
import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.SQLiteTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;
import org.springframework.batch.item.file.LineMapper;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Scanner;

public class DneLineImporter<T> {

	private static final Configuration CONFIGURATION = new Configuration(new SQLiteTemplates());

	private final LineMapper<T> lineMapper;

	private final RelationalPath<T> relationalPath;

	private DneLineImporter(LineMapper<T> lineMapper, RelationalPath<T> relationalPath) {
		this.lineMapper = lineMapper;
		this.relationalPath = relationalPath;
	}

	public static <T> DneLineImporter<T> of(LineMapper<T> lineMapper, RelationalPath<T> relationalPath) {
		return new DneLineImporter<T>(lineMapper, relationalPath);
	}

	public void importLine(Connection conn, InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream);
		int index = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			try {
				T bean = lineMapper.mapLine(line, index++);
				new SQLInsertClause(conn, CONFIGURATION, relationalPath)
						.populate(bean).execute();
			}
			catch (Exception e) {
				throw new IllegalArgumentException(String.format("Erro ao importar linha '%s'", line), e);
			}
		}
	}

}
