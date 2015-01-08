package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaCpc;
import me.yanaga.dne.app.bean.LogFaixaCpcPK;
import me.yanaga.dne.app.bean.LogFaixaCpcRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogFaixaCpcCarga extends CargaAbstract<LogFaixaCpc, LogFaixaCpcPK> {

	private LogFaixaCpcRepository logFaixaCpcRepository;

	private LineMapper<LogFaixaCpc> logFaixaCpcLineMapper;

	private LogFaixaCpcCarga() {
		super(LogFaixaCpc.class);
	}

	public static LogFaixaCpcCarga logFaixaCpc() {
		return new LogFaixaCpcCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_FAIXA_CPC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logFaixaCpcLineMapper = getBeanMapper().logFaixaCpcLineMapper();
	}

	@Override
	public LineMapper<LogFaixaCpc> lineMapper() {
		return checkNotNull(logFaixaCpcLineMapper);
	}

	@Override
	protected void configRepository() {
		logFaixaCpcRepository = getBean(LogFaixaCpcRepository.class);
	}

	@Override
	public JpaRepository<LogFaixaCpc, LogFaixaCpcPK> repository() {
		return checkNotNull(logFaixaCpcRepository);
	}
}
