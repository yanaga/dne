package me.yanaga.dne.app.components.carga;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import me.yanaga.dne.config.root.BatchConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public abstract class CargaAbstract<T, ID extends Serializable> {

	static Logger logger = LoggerFactory.getLogger(CargaAbstract.class);

	public static final int PAGE = 1000;

	private Class<T> beanClass;

	private ApplicationContext context;

	private Path dirFiles;

	protected LineMapper<T> lineMapper;

	protected JpaRepository<T, ID> repository;

	public CargaAbstract(Class<T> beanClass) {
		this.beanClass = beanClass;
	}

	public void config(ApplicationContext context) {
		checkNotNull(context);
		this.context = context;
		checkArgument(!Strings.isNullOrEmpty(System.getenv("DNE_FILES")), "Varável de ambiente 'DNE_FILES' deve ser preenchida.");
		this.dirFiles = Paths.get(System.getenv("DNE_FILES"));
		configLineMapper();
		configRepository();
	}

	protected BatchConfig getBeanMapper() {
		return getBean(BatchConfig.class);
	}

	protected <B> B getBean(Class<B> aClass) {
		return checkNotNull(context).getBean(aClass);
	}

	public void run() {
		checkNotNull(lineMapper);
		checkNotNull(repository);
		checkNotNull(dirFiles);
		try (Stream<Path> files = Files.list(dirFiles)
				.filter(p -> Arrays.asList(getArquivos()).contains(p.getFileName().toString()))) {
			Iterator<Path> itDir = files.iterator();
			while (itDir.hasNext()) {
				Path pathFile = itDir.next();
				logger.info(String.format("Populando '%s' com o arquivo '%s'", beanClass.getSimpleName(), pathFile.getFileName()));
				for (int pageNum = 0; ; pageNum++) {
					try (Stream<String> lines = Files.lines(pathFile, Charset.forName("ISO-8859-1"))) {
						ImmutableList.Builder<T> builder = ImmutableList.builder();
						lines.skip(pageNum * CargaAbstract.PAGE)
								.limit(CargaAbstract.PAGE)
								.forEach(line -> {
									try {
										builder.add(lineMapper.mapLine(line.replaceAll("\"", "'"), 1));
									}
									catch (Exception ex) {
										logger.error(String.format("Não foi possível preencher campos de '%s' com '%s'", beanClass.getSimpleName(), line));
									}
								});
						if (repository.save(builder.build()).isEmpty()) {
							break;
						}
					}
					catch (Exception ex) {
						logger.error(String.format("Erro ao fazer a carga em '%s'", beanClass.getSimpleName()), ex);
					}
				}
			}
		} catch (IOException ex) {
			throw new RuntimeException("Erro ao realizar a carga de dados.", ex);
		}
		logger.info("Carga finalizada.");
	}

	protected abstract String[] getArquivos();

	protected abstract void configLineMapper();

	protected abstract void configRepository();
}