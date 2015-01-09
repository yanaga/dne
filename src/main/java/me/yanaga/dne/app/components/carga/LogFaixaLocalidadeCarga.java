package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaLocalidade;
import me.yanaga.dne.app.bean.LogFaixaLocalidadePK;
import me.yanaga.dne.app.bean.LogFaixaLocalidadeRepository;

public class LogFaixaLocalidadeCarga extends CargaAbstract<LogFaixaLocalidade, LogFaixaLocalidadePK> {

	private LogFaixaLocalidadeCarga() {
		super(LogFaixaLocalidade.class);
	}

	public static LogFaixaLocalidadeCarga logFaixaLocalidade() {
		return new LogFaixaLocalidadeCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_FAIXA_LOCALIDADE.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logFaixaLocalidadeLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogFaixaLocalidadeRepository.class);
	}
}
