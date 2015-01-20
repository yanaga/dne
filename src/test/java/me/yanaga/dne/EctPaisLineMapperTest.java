package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.app.BatchConfig;
import me.yanaga.dne.sqlite.bean.EctPais;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class EctPaisLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<EctPais> ectPaisLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "AF@AFG@Afeganistão@Afghanistan@Afghanistan@" },
				{ "ZA@ZAF@África do Sul@South Africa@Afrique Du Sud@" },
				{ "AL@ALB@Albânia@Albania@Albanie@" },
				{ "DE@DEU@Alemanha@Germany@Allemagne@" },
				{ "AD@AND@Andorra@Andorra@Andorre@" },
				{ "AO@AGO@Angola@Angola@Angola@" },
				{ "AI@AIA@Anguilla@Anguilla@@" },
				{ "AQ@ATA@Antárctica@Antarctic@@" }
		};
	}

	@Test(dataProvider = "lines")
	public void testEctPaisLineMaper(String line) throws Exception {
		EctPais ectPais = ectPaisLineMapper.mapLine(line, 1);
		assertTrue(!Strings.isNullOrEmpty(ectPais.getPaiSg()));
		assertNotNull(ectPais.getPaiSgAlternativa());
		assertNotNull(ectPais.getPaiNoPortugues());
		assertNotNull(ectPais.getPaiNoIngles());
		assertNotNull(ectPais.getPaiNoFrances());
		assertNotNull(ectPais.getPaiAbreviatura());
	}

	@Test
	public void testValues() throws Exception {
		EctPais ectPais = ectPaisLineMapper.mapLine("AF@AFG@Afeganistão@Afghanistan@Afghanistan@", 1);
		assertEquals(ectPais.getPaiSg(), "AF");
		assertEquals(ectPais.getPaiSgAlternativa(), "AFG");
		assertEquals(ectPais.getPaiNoPortugues(), "Afeganistão");
		assertEquals(ectPais.getPaiNoIngles(), "Afghanistan");
		assertEquals(ectPais.getPaiNoFrances(), "Afghanistan");
		assertTrue(Strings.isNullOrEmpty(ectPais.getPaiAbreviatura()));
	}

}
