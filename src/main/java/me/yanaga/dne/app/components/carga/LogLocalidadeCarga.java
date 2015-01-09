package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogLocalidade;
import me.yanaga.dne.app.bean.LogLocalidadeRepository;

public class LogLocalidadeCarga extends CargaAbstract<LogLocalidade, Integer> {

	private LogLocalidadeCarga() {
		super(LogLocalidade.class);
	}

	public static LogLocalidadeCarga logLocalidade() {
		return new LogLocalidadeCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_LOCALIDADE.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logLocalidadeLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogLocalidadeRepository.class);
	}
}
