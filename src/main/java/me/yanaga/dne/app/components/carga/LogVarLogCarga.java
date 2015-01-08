package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogVarLog;
import me.yanaga.dne.app.bean.LogVarLogPK;
import me.yanaga.dne.app.bean.LogVarLogRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogVarLogCarga extends CargaAbstract<LogVarLog, LogVarLogPK> {

	private LineMapper<LogVarLog> logVarLogLineMapper;

	private LogVarLogRepository logVarLogRepository;

	private LogVarLogCarga() {
		super(LogVarLog.class);
	}

	public static LogVarLogCarga logVarLog() {
		return new LogVarLogCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_VAR_LOG.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logVarLogLineMapper = getBeanMapper().logVarLogLineMapper();
	}

	@Override
	public LineMapper<LogVarLog> lineMapper() {
		return checkNotNull(logVarLogLineMapper);
	}

	@Override
	protected void configRepository() {
		logVarLogRepository = getBean(LogVarLogRepository.class);
	}

	@Override
	public JpaRepository<LogVarLog, LogVarLogPK> repository() {
		return checkNotNull(logVarLogRepository);
	}
}
