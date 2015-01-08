package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogLocalidade;
import me.yanaga.dne.app.bean.LogLocalidadeRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogLocalidadeCarga extends CargaAbstract<LogLocalidade, Integer> {

	private LineMapper<LogLocalidade> logLocalidadeLineMapper;

	private LogLocalidadeRepository logLocalidadeRepository;

	private LogLocalidadeCarga() {
		super(LogLocalidade.class);
	}

	public static LogLocalidadeCarga logLocalidade() {
		return new LogLocalidadeCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_LOCALIDADE.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logLocalidadeLineMapper = getBeanMapper().logLocalidadeLineMapper();
	}

	@Override
	public LineMapper<LogLocalidade> lineMapper() {
		return checkNotNull(logLocalidadeLineMapper);
	}

	@Override
	protected void configRepository() {
		logLocalidadeRepository = getBean(LogLocalidadeRepository.class);
	}

	@Override
	public JpaRepository<LogLocalidade, Integer> repository() {
		return checkNotNull(logLocalidadeRepository);
	}
}
