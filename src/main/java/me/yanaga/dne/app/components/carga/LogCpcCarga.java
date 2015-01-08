package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogCpc;
import me.yanaga.dne.app.bean.LogCpcRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogCpcCarga extends CargaAbstract<LogCpc, Integer> {

	private LineMapper<LogCpc> logCpcLineMapper;

	private LogCpcRepository logCpcRepository;

	private LogCpcCarga() {
		super(LogCpc.class);
	}

	public static LogCpcCarga logCpc() {
		return new LogCpcCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_CPC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logCpcLineMapper = getBeanMapper().logCpcLineMapper();
	}

	@Override
	public LineMapper<LogCpc> lineMapper() {
		return checkNotNull(logCpcLineMapper);
	}

	@Override
	protected void configRepository() {
		this.logCpcRepository = getBean(LogCpcRepository.class);
	}

	@Override
	public JpaRepository<LogCpc, Integer> repository() {
		return checkNotNull(logCpcRepository);
	}
}
