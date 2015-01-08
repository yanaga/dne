package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.EctPais;
import me.yanaga.dne.app.bean.EctPaisRepository;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class EctPaisCarga extends CargaAbstract<EctPais, String> {

	private LineMapper<EctPais> ectPaisLineMapper;

	private EctPaisRepository ectPaisRepository;

	private EctPaisCarga() {
		super(EctPais.class);
	}

	public static EctPaisCarga ectPais() {
		return new EctPaisCarga();
	}

	@Override
	public String[] getArquivos() {
		return new String[] { "ECT_PAIS.TXT" };
	}

	@Override
	protected void configLineMapper() {
		ectPaisLineMapper = getBeanMapper().ectPaisLineMapper();
	}

	@Override
	public LineMapper<EctPais> lineMapper() {
		return checkNotNull(ectPaisLineMapper);
	}

	@Override
	protected void configRepository() {
		ectPaisRepository = getBean(EctPaisRepository.class);
	}

	@Override
	public JpaRepository<EctPais, String> repository() {
		return checkNotNull(ectPaisRepository);
	}
}
