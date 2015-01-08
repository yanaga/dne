package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogUnidOper;
import me.yanaga.dne.app.bean.LogUnidOperRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogUnidOperCarga extends CargaAbstract<LogUnidOper, Integer> {

	private LineMapper<LogUnidOper> logUnidOperLineMapper;

	private LogUnidOperRepository logUnidOperRepository;

	private LogUnidOperCarga() {
		super(LogUnidOper.class);
	}

	public static LogUnidOperCarga logUnidOper() {
		return new LogUnidOperCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_UNID_OPER.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logUnidOperLineMapper = getBeanMapper().logUnidOperLineMapper();
	}

	@Override
	public LineMapper<LogUnidOper> lineMapper() {
		return checkNotNull(logUnidOperLineMapper);
	}

	@Override
	protected void configRepository() {
		logUnidOperRepository = getBean(LogUnidOperRepository.class);
	}

	@Override
	public JpaRepository<LogUnidOper, Integer> repository() {
		return checkNotNull(logUnidOperRepository);
	}
}
