package me.yanaga.dne.app.bean;

import com.google.common.collect.Lists;
import me.yanaga.dne.config.root.DneConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.assertFalse;

@ActiveProfiles("desenvolvimento")
@ContextConfiguration(classes = { DneConfig.class })
@Transactional
public class PopulaBancoIT extends AbstractTransactionalTestNGSpringContextTests {

	protected static final Logger logger = LoggerFactory.getLogger(PopulaBancoIT.class);

	private static final String PATH = String.format("%s/Delimitado-ISO-8859-1", System.getProperty("user.dir"));

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
	private LogCpcRepository logCpcRepository;

	@Autowired
	private LineMapper<LogFaixaBairro> logFaixaBairroLineMapper;

	@Autowired
	private LogFaixaBairroRepository logFaixaBairroRepository;

	@Autowired
	private LineMapper<LogFaixaCpc> logFaixaCpcLineMapper;

	@Autowired
	private LogFaixaCpcRepository logFaixaCpcRepository;

	@Autowired
	private LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper;

	@Autowired
	private LogFaixaLocalidadeRepository logFaixaLocalidadeRepository;

	@Autowired
	private LineMapper<LogFaixaUf> logFaixaUfLineMapper;

	@Autowired
	private LogFaixaUfRepository logFaixaUfRepository;

	@Autowired
	private LineMapper<LogFaixaUop> logFaixaUopLineMapper;

	@Autowired
	private LogFaixaUopRepository logFaixaUopRepository;

	@Autowired
	private LineMapper<LogGrandeUsuario> logGrandeUsuarioLineMapper;

	@Autowired
	private LogGrandeUsuarioRepository logGrandeUsuarioRepository;

	@Autowired
	private LineMapper<LogLocalidade> logLocalidadeLineMapper;

	@Autowired
	private LogLocalidadeRepository logLocalidadeRepository;

	@Autowired
	private LineMapper<LogLogradouro> logLogradouroLineMapper;

	@Autowired
	private LogLogradouroRepository logLogradouroRepository;

	@Autowired
	private LineMapper<LogNumSec> logNumSecLineMapper;

	@Autowired
	private LogNumSecRepository logNumSecRepository;

	@Autowired
	private LineMapper<LogUnidOper> logUnidOperLineMapper;

	@Autowired
	private LogUnidOperRepository logUnidOperRepository;

	@Autowired
	private LineMapper<LogVarBai> logVarBaiLineMapper;

	@Autowired
	private LogVarBaiRepository logVarBaiRepository;

	@Autowired
	private LineMapper<LogVarLoc> logVarLocLineMapper;

	@Autowired
	private LogVarLocRepository logVarLocRepository;

	@Autowired
	private LineMapper<LogVarLog> logVarLogLineMapper;

	@Autowired
	private LogVarLogRepository logVarLogRepository;

	@DataProvider(name = "tabelas")
	private Object[][] tabelas() {
		return new Object[][] {
				{ EctPais.class.getSimpleName(), new String[] {"ECT_PAIS.TXT"}, ectPaisLineMapper, ectPaisRepository },
				{ LogBairro.class.getSimpleName(), new String[] {"LOG_BAIRRO.TXT"}, logBairroLineMapper, logBairroRepository },
				{ LogCpc.class.getSimpleName(), new String[] {"LOG_CPC.TXT"}, logCpcLineMapper, logCpcRepository },
				{ LogFaixaBairro.class.getSimpleName(), new String[] {"LOG_FAIXA_BAIRRO.TXT"}, logFaixaBairroLineMapper, logFaixaBairroRepository },
				{ LogFaixaCpc.class.getSimpleName(), new String[] {"LOG_FAIXA_CPC.TXT"}, logFaixaCpcLineMapper, logFaixaCpcRepository },
				{ LogFaixaLocalidade.class.getSimpleName(), new String[] {"LOG_FAIXA_LOCALIDADE.TXT"}, logFaixaLocalidadeLineMapper, logFaixaLocalidadeRepository },
				{ LogFaixaUf.class.getSimpleName(), new String[] {"LOG_FAIXA_UF.TXT"}, logFaixaUfLineMapper, logFaixaUfRepository },
				{ LogFaixaUop.class.getSimpleName(), new String[] {"LOG_FAIXA_UOP.TXT"}, logFaixaUopLineMapper, logFaixaUopRepository },
				{ LogGrandeUsuario.class.getSimpleName(), new String[] {"LOG_GRANDE_USUARIO.TXT"}, logGrandeUsuarioLineMapper, logGrandeUsuarioRepository },
				{ LogLocalidade.class.getSimpleName(), new String[] {"LOG_LOCALIDADE.TXT"}, logLocalidadeLineMapper, logLocalidadeRepository },
				{ LogLogradouro.class.getSimpleName(), new String[] {
						"LOG_LOGRADOURO_AC.TXT", "LOG_LOGRADOURO_AL.TXT", "LOG_LOGRADOURO_AM.TXT", "LOG_LOGRADOURO_AP.TXT",
						"LOG_LOGRADOURO_BA.TXT", "LOG_LOGRADOURO_CE.TXT", "LOG_LOGRADOURO_DF.TXT", "LOG_LOGRADOURO_ES.TXT",
						"LOG_LOGRADOURO_GO.TXT", "LOG_LOGRADOURO_MA.TXT", "LOG_LOGRADOURO_MG.TXT", "LOG_LOGRADOURO_MS.TXT",
						"LOG_LOGRADOURO_MT.TXT", "LOG_LOGRADOURO_PA.TXT", "LOG_LOGRADOURO_PB.TXT", "LOG_LOGRADOURO_PE.TXT",
						"LOG_LOGRADOURO_PI.TXT", "LOG_LOGRADOURO_PR.TXT", "LOG_LOGRADOURO_RJ.TXT", "LOG_LOGRADOURO_RN.TXT",
						"LOG_LOGRADOURO_RO.TXT", "LOG_LOGRADOURO_RR.TXT", "LOG_LOGRADOURO_RS.TXT", "LOG_LOGRADOURO_SC.TXT",
						"LOG_LOGRADOURO_SE.TXT", "LOG_LOGRADOURO_SP.TXT", "LOG_LOGRADOURO_TO.TXT"
				}, logLogradouroLineMapper, logLogradouroRepository },
				{ LogNumSec.class.getSimpleName(), new String[] {"LOG_NUM_SEC.TXT"}, logNumSecLineMapper, logNumSecRepository },
				{ LogUnidOper.class.getSimpleName(), new String[] {"LOG_UNID_OPER.TXT"}, logUnidOperLineMapper, logUnidOperRepository },
				{ LogVarBai.class.getSimpleName(), new String[] {"LOG_VAR_BAI.TXT"}, logVarBaiLineMapper, logVarBaiRepository },
				{ LogVarLoc.class.getSimpleName(), new String[] {"LOG_VAR_LOC.TXT"}, logVarLocLineMapper, logVarLocRepository },
				{ LogVarLog.class.getSimpleName(), new String[] {"LOG_VAR_LOG.TXT"}, logVarLogLineMapper, logVarLogRepository }
		};
	}

	@Test(dataProvider = "tabelas")
	@Rollback(false)
	public void populaTabelas(String nomeClasse, String[] nomesArquivos, LineMapper lineMapper, JpaRepository repository)
			throws IOException {
		logger.info(String.format("Populando %s.", nomeClasse));
		boolean error = false;
		Path pathDir = Paths.get(PATH);
		try (Stream<Path> files = Files.list(pathDir)
				.filter(p -> Arrays.asList(nomesArquivos).contains(p.getFileName().toString()))) {
			Iterator<Path> itDir = files.iterator();
			while (itDir.hasNext()) {
				Path pathFile = itDir.next();
				logger.info(String.format("Arquivo: '%s'", pathFile.getFileName()));
				for (int pagina = 0; ;pagina++) {
					try (Stream<String> lines = Files.lines(pathFile, Charset.forName("ISO-8859-1"))) {
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
					}
					catch (Exception ex) {
						error = true;
						logger.error(String.format("Erro ao popular %s", nomeClasse), ex);
					}
				}
			}
		}
		assertFalse(error);
	}
}
