package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogCpc;
import me.yanaga.dne.app.bean.LogCpcRepository;

public class LogCpcCarga extends CargaAbstract<LogCpc, Integer> {

	private LogCpcCarga() {
		super(LogCpc.class);
	}

	public static LogCpcCarga logCpc() {
		return new LogCpcCarga();
	}

	@Override
	protected String[] getArquivos() {
		return new String[] { "LOG_CPC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		lineMapper = getBeanMapper().logCpcLineMapper();
	}

	@Override
	protected void configRepository() {
		this.repository = getBean(LogCpcRepository.class);
	}
}
