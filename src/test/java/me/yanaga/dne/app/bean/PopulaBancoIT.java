package me.yanaga.dne.app.bean;

import com.google.common.collect.Lists;
import me.yanaga.dne.config.root.DneConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.assertFalse;

@ActiveProfiles("desenvolvimento")
@ContextConfiguration(classes = { DneConfig.class })
@Transactional
public class PopulaBancoIT extends AbstractTestNGSpringContextTests {

	protected static final Logger logger = LoggerFactory.getLogger(PopulaBancoIT.class);

	private static final String PATH = "/home/kaissi/Downloads/Delimitador";

	private static final int TAMANHO_PAGINA = 50;

	@Autowired
	private LineMapper<EctPais> ectPaisLineMapper;

	@Autowired
	private EctPaisRepository ectPaisRepository;

	@Autowired
	private LineMapper<LogBairro> logBairroLineMapper;

	@Autowired
	private LogBairroRepository logBairroRepository;

	@Autowired
	private LineMapper<LogCpc> logCpcLineMapper;

	@Autowired
	private LineMapper<LogFaixaBairro> logFaixaBairroLineMapper;

	@Autowired
	private LineMapper<LogFaixaCpc> logFaixaCpcLineMapper;

	@Autowired
	private LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper;

	@Autowired
	private LineMapper<LogFaixaUf> logFaixaUfLineMapper;

	@Autowired
	private LineMapper<LogFaixaUop> logFaixaUopLineMapper;

	@Autowired
	private LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper;

	@Autowired
	private LineMapper<LogLocalidade> logLocalidadeLineMapper;

	@Autowired
	private LineMapper<LogLogradouro> logLogradouroLineMapper;

	@Autowired
	private LineMapper<LogNumSec> logNumSecLineMapper;

	@Autowired
	private LineMapper<LogUnidOper> logUnidOperLineMapper;

	@Autowired
	private LineMapper<LogVarBai> logVarBaiLineMapper;

	@Autowired
	private LineMapper<LogVarLoc> logVarLocLineMapper;

	@Autowired
	private LineMapper<LogVarLog> logVarLogLineMapper;

	@DataProvider(name = "tabelas")
	private Object[][] tabelas() {
		return new Object[][] {
				{ EctPais.class.getSimpleName(), EctPais.FILE_NAME, ectPaisLineMapper, ectPaisRepository },
				{ LogBairro.class.getSimpleName(), LogBairro.FILE_NAME, logBairroLineMapper, logBairroRepository }
		};
	}

	private Path getPath(Object fileName) {
		return Paths.get(PATH, String.format("%s.TXT", fileName));
	}

	@Test(dataProvider = "tabelas")
	public void populaTabelas(String nomeClasse, String nomeArquivo, LineMapper lineMapper, JpaRepository repository) {
		logger.info(String.format("Populando %s.", nomeClasse));
		boolean error = false;
		Path path = getPath(nomeArquivo);
		int pagina = 0;
		do {
			try(Stream<String> lines = Files.lines(path)) {
				Iterator<String> requestPage = lines.skip(pagina * TAMANHO_PAGINA).limit(TAMANHO_PAGINA).iterator();
				if (!requestPage.hasNext()) {
					break;
				}
				List<Object> objetos = Lists.newLinkedList();
				while (requestPage.hasNext()) {
					String line = requestPage.next();
					try {
						objetos.add(lineMapper.mapLine(line.replaceAll("\"", "'"), 1));
					}
					catch (Exception ex) {
						error = true;
						logger.error(String.format("Não foi possível preencher campos de %s com '%s'", nomeClasse, line));
					}
				}
				if (!objetos.isEmpty()) {
					repository.save(objetos);
				}
				pagina++;
			} catch (Exception ex) {
				error = true;
				logger.error(String.format("Erro ao popular %s", nomeClasse), ex);
			}
		} while (true);
		assertFalse(error);
	}
}
