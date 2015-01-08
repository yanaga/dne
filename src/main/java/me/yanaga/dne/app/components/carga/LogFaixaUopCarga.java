package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogFaixaUop;
import me.yanaga.dne.app.bean.LogFaixaUopPK;
import me.yanaga.dne.app.bean.LogFaixaUopRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogFaixaUopCarga extends CargaAbstract<LogFaixaUop, LogFaixaUopPK> {

	private LineMapper<LogFaixaUop> logFaixaUopLineMapper;

	private LogFaixaUopRepository logFaixaUopRepository;

	private LogFaixaUopCarga() {
		super(LogFaixaUop.class);
	}

	public static LogFaixaUopCarga logFaixaUop() {
		return new LogFaixaUopCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_FAIXA_UOP.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logFaixaUopLineMapper = getBeanMapper().logFaixaUopLineMapper();
	}

	@Override
	public LineMapper<LogFaixaUop> lineMapper() {
		return checkNotNull(logFaixaUopLineMapper);
	}

	@Override
	protected void configRepository() {
		logFaixaUopRepository = getBean(LogFaixaUopRepository.class);
	}

	@Override
	public JpaRepository<LogFaixaUop, LogFaixaUopPK> repository() {
		return checkNotNull(logFaixaUopRepository);
	}
}
