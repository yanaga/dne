package me.yanaga.dne;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogUnidOperLineTokenizerTest extends AbstractTestNGSpringContextTests {

	@Resource
	private DelimitedLineTokenizer logUnidOperLineTokenizer;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "23904@AC@11059@51784@@AC Campinas@Rua Kaxinawás@69929970@N@" },
				{ "12045@AC@9@39336@@AC Jordão@Avenida Francisco Dias, s/n@69975970@N@" },
				{ "12038@AC@2@39329@@AC Assis Brasil@Avenida Raimundo Chaar 230@69935970@N@" },
				{ "12036@AC@3@39327@@AC Brasiléia@Avenida Prefeito Rolando Moreira 336@69932970@S@" },
				{ "12050@AC@10@39341@@AC Mâncio Lima@Avenida Japim 60@69990970@N@" },
				{ "12041@AC@11@39332@@AC Manoel Urbano@Rua Valério Caldas Magalhães, s/n@69950970@N@" },
				{ "12048@AC@12@39339@@AC Marechal Thaumaturgo@Avenida Principal, s/n@69983970@N@AC Mal Thaumaturgo" },
				{ "11988@AC@13@39325@@AC Plácido de Castro@Rua Coronel Fontinelle de Castro 441@69928970@N@AC Plácido Castro" },
		};
	}

	@Test(dataProvider = "lines")
	public void testLogUnidOperLineTokenizer(String line) {
		FieldSet fieldSet = logUnidOperLineTokenizer.tokenize(line);
		assertTrue(fieldSet.readLong("UOP_NU") > 0);
		assertEquals(fieldSet.readString("UFE_SG"), "AC");
		assertNotNull(fieldSet.readString("UOP_ENDERECO"));
		assertTrue(fieldSet.readString("CEP").matches("\\d{8}"));
	}

	@Test
	public void testValues() {
		FieldSet fieldSet = logUnidOperLineTokenizer.tokenize("23904@AC@11059@51784@@AC Campinas@Rua Kaxinawás@69929970@N@");
		assertEquals(fieldSet.readLong("UOP_NU"), 23904);
		assertEquals(fieldSet.readString("UFE_SG"), "AC");
		assertNotNull(fieldSet.readString("UOP_ENDERECO"), "Rua Kaxinawás");
		assertEquals(fieldSet.readString("CEP"), "69929970");
	}

}
