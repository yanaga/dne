package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.LogVarBai;
import me.yanaga.dne.app.bean.LogVarBaiPK;
import me.yanaga.dne.app.bean.LogVarBaiRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class LogVarBaiCarga extends CargaAbstract<LogVarBai, LogVarBaiPK> {

	private LineMapper<LogVarBai> logVarBaiLineMapper;

	private LogVarBaiRepository logVarBaiRepository;

	private LogVarBaiCarga() {
		super(LogVarBai.class);
	}

	public static LogVarBaiCarga logVarBai() {
		return new LogVarBaiCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "LOG_VAR_BAI.TXT" };
	}

	@Override
	protected void configLineMapper() {
		logVarBaiLineMapper = getBeanMapper().logVarBaiLineMapper();
	}

	@Override
	public LineMapper<LogVarBai> lineMapper() {
		return checkNotNull(logVarBaiLineMapper);
	}

	@Override
	protected void configRepository() {
		logVarBaiRepository = getBean(LogVarBaiRepository.class);
	}

	@Override
	public JpaRepository<LogVarBai, LogVarBaiPK> repository() {
		return checkNotNull(logVarBaiRepository);
	}
}
