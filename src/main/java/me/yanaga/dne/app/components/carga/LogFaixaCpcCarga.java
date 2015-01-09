package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaCpc;
import me.yanaga.dne.app.bean.LogFaixaCpcPK;
import me.yanaga.dne.app.bean.LogFaixaCpcRepository;

public class LogFaixaCpcCarga extends CargaAbstract<LogFaixaCpc, LogFaixaCpcPK> {

	private LogFaixaCpcCarga() {
		super(LogFaixaCpc.class);
	}

	public static LogFaixaCpcCarga logFaixaCpc() {
		return new LogFaixaCpcCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_FAIXA_CPC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logFaixaCpcLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(LogFaixaCpcRepository.class);
	}
}
