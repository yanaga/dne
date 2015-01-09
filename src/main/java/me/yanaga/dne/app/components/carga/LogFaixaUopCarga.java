package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaUop;
import me.yanaga.dne.app.bean.LogFaixaUopPK;
import me.yanaga.dne.app.bean.LogFaixaUopRepository;

public class LogFaixaUopCarga extends CargaAbstract<LogFaixaUop, LogFaixaUopPK> {

	private LogFaixaUopCarga() {
		super(LogFaixaUop.class);
	}

	public static LogFaixaUopCarga logFaixaUop() {
		return new LogFaixaUopCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_FAIXA_UOP.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logFaixaUopLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogFaixaUopRepository.class);
	}
}
