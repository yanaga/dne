package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogVarLoc;
import me.yanaga.dne.app.bean.LogVarLocPK;
import me.yanaga.dne.app.bean.LogVarLocRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogVarLocCarga extends CargaAbstract<LogVarLoc, LogVarLocPK> {

	private LineMapper<LogVarLoc> logVarLocLineMapper;

	private LogVarLocRepository logVarLocRepository;

	private LogVarLocCarga() {
		super(LogVarLoc.class);
	}

	public static LogVarLocCarga logVarLoc() {
		return new LogVarLocCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_VAR_LOC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logVarLocLineMapper = getBeanMapper().logVarLocLineMapper();
	}

	@Override
	public LineMapper<LogVarLoc> lineMapper() {
		return checkNotNull(logVarLocLineMapper);
	}

	@Override
	protected void configRepository() {
		logVarLocRepository = getBean(LogVarLocRepository.class);
	}

	@Override
	public JpaRepository<LogVarLoc, LogVarLocPK> repository() {
		return checkNotNull(logVarLocRepository);
	}
}
