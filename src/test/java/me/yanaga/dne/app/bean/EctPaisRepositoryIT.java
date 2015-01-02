package me.yanaga.dne.app.bean;

import me.yanaga.dne.config.root.DneConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@ActiveProfiles("desenvolvimento")
@ContextConfiguration(classes = { DneConfig.class })
public class EctPaisRepositoryIT extends AbstractTestNGSpringContextTests {

	@Autowired
	private EctPaisRepository ectPaisRepository;

	@Test
	public void testeEctPais() {
		EctPais ectPais = new EctPais();
		ectPais.setPaiSg("XX");
		ectPais.setPaiSgAlternativa("XXX");
		ectPais.setPaiNoPortugues("PAÍS PORTUGUES");
		ectPais.setPaiNoIngles("PAÍS INGLES");
		ectPais.setPaiNoFrances("PAIS FRANÇÊS");
		ectPais.setPaiAbreviatura("");
		ectPaisRepository.save(ectPais);

		assertTrue(ectPaisRepository.findAll().size() > 0);
		ectPaisRepository.delete(ectPais); //-- TODO Não está fazendo Rollback
	}
}