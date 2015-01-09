package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogBairro;
import me.yanaga.dne.app.bean.LogBairroRepository;

public class LogBairroCarga extends CargaAbstract<LogBairro, Integer> {

	private LogBairroCarga() {
		super(LogBairro.class);
	}

	public static LogBairroCarga logBairro() {
		return new LogBairroCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_BAIRRO.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logBairroLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogBairroRepository.class);
	}
}
