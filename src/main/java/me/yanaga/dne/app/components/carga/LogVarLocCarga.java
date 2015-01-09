package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogVarLoc;
import me.yanaga.dne.app.bean.LogVarLocPK;
import me.yanaga.dne.app.bean.LogVarLocRepository;

public class LogVarLocCarga extends CargaAbstract<LogVarLoc, LogVarLocPK> {

	private LogVarLocCarga() {
		super(LogVarLoc.class);
	}

	public static LogVarLocCarga logVarLoc() {
		return new LogVarLocCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_VAR_LOC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logVarLocLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogVarLocRepository.class);
	}
}
