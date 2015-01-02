package me.yanaga.dne.config.root.database;

import me.yanaga.dne.config.annotation.Embedded;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Embedded
@Configuration
public class EmbeddedDatabaseConfig extends DatabaseConfigAbstract {

	@Override
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:create.sql")
				.build();
	}

	@Override
	protected String getPersistenceUnitName() {
		return "embedded";
	}

	protected String getUrl() {
		return "";
	}

	protected String getUsername() {
		return "";
	}

	protected String getPassword() {
		return "";
	}
}