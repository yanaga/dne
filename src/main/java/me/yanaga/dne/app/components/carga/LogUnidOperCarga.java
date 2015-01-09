package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogUnidOper;
import me.yanaga.dne.app.bean.LogUnidOperRepository;

public class LogUnidOperCarga extends CargaAbstract<LogUnidOper, Integer> {

	private LogUnidOperCarga() {
		super(LogUnidOper.class);
	}

	public static LogUnidOperCarga logUnidOper() {
		return new LogUnidOperCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_UNID_OPER.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logUnidOperLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogUnidOperRepository.class);
	}
}
