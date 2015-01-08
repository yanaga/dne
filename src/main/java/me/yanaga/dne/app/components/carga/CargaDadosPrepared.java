package me.yanaga.dne.app.components.carga;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class CargaDadosPrepared {

	protected static final Logger logger = LoggerFactory.getLogger(CargaDadosPrepared.class);

	private CargaDados cargaDados;

	public CargaDadosPrepared(CargaDados cargaDados) {
		this.cargaDados = cargaDados;
	}

	public void run() throws IOException {
		logger.info(String.format("Fazendo a carga no banco '%s' com os arquivos da pasta '%s'",
				System.getenv("DATABASE_URL"), System.getenv("DNE_FILES")));
		for (CargaAbstract carga : cargaDados.getCargasConfigured()) {
			try (Stream<Path> files = Files.list(Paths.get(System.getenv("DNE_FILES")))
					.filter(p -> Arrays.asList(carga.getArquivos()).contains(p.getFileName().toString()))) {
				Iterator<Path> itDir = files.iterator();
				while (itDir.hasNext()) {
					Path pathFile = itDir.next();
					logger.info(String.format("Populando '%s' com o arquivo '%s'", carga.getName(), pathFile.getFileName()));
					for (int pageNum = 0; ; pageNum++) {
						try (Stream<String> lines = Files.lines(pathFile, Charset.forName("ISO-8859-1"))) {
							ImmutableList.Builder<Object> builder = ImmutableList.builder();
							lines.skip(pageNum * CargaAbstract.PAGE)
									.limit(CargaAbstract.PAGE)
									.forEach(line -> {
										try {
											builder.add(carga.lineMapper().mapLine(line.replaceAll("\"", "'"), 1));
										}
										catch (Exception ex) {
											logger.error(String.format("Não foi possível preencher campos de '%s' com '%s'", carga.getName(), line));
										}
									}
							);
							if (carga.repository().save(builder.build()).isEmpty()) {
								break;
							}
						}
						catch (Exception ex) {
							logger.error(String.format("Erro ao fazer a carga em '%s'", carga.getName()), ex);
						}
					}
				}
			}
		}
		logger.info("Carga finalizada.");
	}
}