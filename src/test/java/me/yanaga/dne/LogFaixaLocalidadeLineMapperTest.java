package me.yanaga.dne;

import me.yanaga.dne.config.root.BatchConfig;
import me.yanaga.dne.app.bean.LogFaixaLocalidade;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogFaixaLocalidadeLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogFaixaLocalidade> logFaixaLocalidadeLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "8344@88900001@88913999" },
				{ "8357@88330001@88339999" },
				{ "8377@89000001@89099999" },
				{ "8390@88350001@88359999" },
				{ "8396@88340001@88349999" },
				{ "8419@89800001@89816199" },
				{ "8430@88800001@88819999" },
				{ "8452@88000001@88099999" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogFaixaLocalidadeLineMapper(String line) throws Exception {
		LogFaixaLocalidade logFaixaLocalidade = logFaixaLocalidadeLineMapper.mapLine(line, 1);
		assertTrue(logFaixaLocalidade.getLocNu() > 0);
		assertTrue(logFaixaLocalidade.getLocCepIni().matches("\\d{8}"));
		assertTrue(logFaixaLocalidade.getLocCepFim().matches("\\d{8}"));
	}

	@Test
	public void testValues() throws Exception {
		LogFaixaLocalidade logFaixaLocalidade = logFaixaLocalidadeLineMapper.mapLine("8344@88900001@88913999", 1);
		assertEquals(logFaixaLocalidade.getLocNu(), new Integer(8344));
		assertEquals(logFaixaLocalidade.getLocCepIni(), "88900001");
		assertEquals(logFaixaLocalidade.getLocCepFim(), "88913999");
	}

}
