package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaUf;
import me.yanaga.dne.app.bean.LogFaixaUfPK;
import me.yanaga.dne.app.bean.LogFaixaUfRepository;

public class LogFaixaUfCarga extends CargaAbstract<LogFaixaUf, LogFaixaUfPK> {

	private LogFaixaUfCarga() {
		super(LogFaixaUf.class);
	}

	public static LogFaixaUfCarga logFaixaUf() {
		return new LogFaixaUfCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_FAIXA_UF.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logFaixaUfLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogFaixaUfRepository.class);
	}
}
