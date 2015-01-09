package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogVarBai;
import me.yanaga.dne.app.bean.LogVarBaiPK;
import me.yanaga.dne.app.bean.LogVarBaiRepository;

public class LogVarBaiCarga extends CargaAbstract<LogVarBai, LogVarBaiPK> {

	private LogVarBaiCarga() {
		super(LogVarBai.class);
	}

	public static LogVarBaiCarga logVarBai() {
		return new LogVarBaiCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_VAR_BAI.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logVarBaiLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogVarBaiRepository.class);
	}
}
