package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaBairro;
import me.yanaga.dne.app.bean.LogFaixaBairroPK;
import me.yanaga.dne.app.bean.LogFaixaBairroRepository;

public class LogFaixaBairroCarga extends CargaAbstract<LogFaixaBairro, LogFaixaBairroPK> {

	private LogFaixaBairroCarga() {
		super(LogFaixaBairro.class);
	}

	public static LogFaixaBairroCarga logFaixaBairro() {
		return new LogFaixaBairroCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_FAIXA_BAIRRO.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logFaixaBairroLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogFaixaBairroRepository.class);
	}
}
