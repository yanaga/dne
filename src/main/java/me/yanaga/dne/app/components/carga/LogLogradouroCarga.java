package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogLogradouro;
import me.yanaga.dne.app.bean.LogLogradouroRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogLogradouroCarga extends CargaAbstract<LogLogradouro, Integer> {

	private LineMapper<LogLogradouro> logLogradouroLineMapper;

	private LogLogradouroRepository logLogradouroRepository;

	private LogLogradouroCarga() {
		super(LogLogradouro.class);
	}

	public static LogLogradouroCarga logLogradouro() {
		return new LogLogradouroCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] {
				"LOG_LOGRADOURO_AC.TXT", "LOG_LOGRADOURO_AL.TXT", "LOG_LOGRADOURO_AM.TXT",
				"LOG_LOGRADOURO_AP.TXT", "LOG_LOGRADOURO_BA.TXT", "LOG_LOGRADOURO_CE.TXT",
				"LOG_LOGRADOURO_DF.TXT", "LOG_LOGRADOURO_ES.TXT", "LOG_LOGRADOURO_GO.TXT",
				"LOG_LOGRADOURO_MA.TXT", "LOG_LOGRADOURO_MG.TXT", "LOG_LOGRADOURO_MS.TXT",
				"LOG_LOGRADOURO_MT.TXT", "LOG_LOGRADOURO_PA.TXT", "LOG_LOGRADOURO_PB.TXT",
				"LOG_LOGRADOURO_PE.TXT", "LOG_LOGRADOURO_PI.TXT", "LOG_LOGRADOURO_PR.TXT",
				"LOG_LOGRADOURO_RJ.TXT", "LOG_LOGRADOURO_RN.TXT", "LOG_LOGRADOURO_RO.TXT",
				"LOG_LOGRADOURO_RR.TXT", "LOG_LOGRADOURO_RS.TXT", "LOG_LOGRADOURO_SC.TXT",
				"LOG_LOGRADOURO_SE.TXT", "LOG_LOGRADOURO_SP.TXT", "LOG_LOGRADOURO_TO.TXT"
		};
	}

	@Override
	protected void configLineMapper() {
		logLogradouroLineMapper = getBeanMapper().logLogradouroLineMapper();
	}

	@Override
	public LineMapper<LogLogradouro> lineMapper() {
		return checkNotNull(logLogradouroLineMapper);
	}

	@Override
	protected void configRepository() {
		logLogradouroRepository = getBean(LogLogradouroRepository.class);
	}

	@Override
	public JpaRepository<LogLogradouro, Integer> repository() {
		return checkNotNull(logLogradouroRepository);
	}
}
