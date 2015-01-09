package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogNumSec;
import me.yanaga.dne.app.bean.LogNumSecRepository;

public class LogNumSecCarga extends CargaAbstract<LogNumSec, Integer> {

	private LogNumSecCarga() {
		super(LogNumSec.class);
	}

	public static LogNumSecCarga logNumSec() {
		return new LogNumSecCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_NUM_SEC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logNumSecLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogNumSecRepository.class);
	}
}
