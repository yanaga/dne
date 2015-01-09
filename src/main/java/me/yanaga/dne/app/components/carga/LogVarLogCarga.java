package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogVarLog;
import me.yanaga.dne.app.bean.LogVarLogPK;
import me.yanaga.dne.app.bean.LogVarLogRepository;

public class LogVarLogCarga extends CargaAbstract<LogVarLog, LogVarLogPK> {

	private LogVarLogCarga() {
		super(LogVarLog.class);
	}

	public static LogVarLogCarga logVarLog() {
		return new LogVarLogCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_VAR_LOG.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logVarLogLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogVarLogRepository.class);
	}
}
