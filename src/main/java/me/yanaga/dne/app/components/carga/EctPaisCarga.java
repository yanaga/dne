package me.yanaga.dne.app.components.carga;

import me.yanaga.dne.app.bean.EctPais;
import me.yanaga.dne.app.bean.EctPaisRepository;

public class EctPaisCarga extends CargaAbstract<EctPais, String> {

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
		lineMapper = getBeanMapper().ectPaisLineMapper();
	}

	@Override
	protected void configRepository() {
		repository = getBean(EctPaisRepository.class);
	}
}
