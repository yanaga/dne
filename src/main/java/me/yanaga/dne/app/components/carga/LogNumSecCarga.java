package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogNumSec;
import me.yanaga.dne.app.bean.LogNumSecRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogNumSecCarga extends CargaAbstract<LogNumSec, Integer> {

	private LineMapper<LogNumSec> logNumSecLineMapper;

	private LogNumSecRepository logNumSecRepository;

	private LogNumSecCarga() {
		super(LogNumSec.class);
	}

	public static LogNumSecCarga logNumSec() {
		return new LogNumSecCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_NUM_SEC.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logNumSecLineMapper = getBeanMapper().logNumSecLineMapper();
	}

	@Override
	public LineMapper<LogNumSec> lineMapper() {
		return checkNotNull(logNumSecLineMapper);
	}

	@Override
	protected void configRepository() {
		logNumSecRepository = getBean(LogNumSecRepository.class);
	}

	@Override
	public JpaRepository<LogNumSec, Integer> repository() {
		return checkNotNull(logNumSecRepository);
	}
}
