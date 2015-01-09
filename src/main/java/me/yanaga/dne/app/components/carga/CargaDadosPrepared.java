package me.yanaga.dne.app.components.carga;

public class CargaDadosPrepared {

	private CargaDados cargaDados;

	public CargaDadosPrepared(CargaDados cargaDados) {
		this.cargaDados = cargaDados;
	}

	public void run() {
		cargaDados.getCargasConfigured().forEach(CargaAbstract::run);
	}
}