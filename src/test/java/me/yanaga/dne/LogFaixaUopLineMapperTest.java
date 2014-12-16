package me.yanaga.dne;

import me.yanaga.dne.sqlite.bean.LogFaixaUop;
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
public class LogFaixaUopLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogFaixaUop> logFaixaUopLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "4329@1@100" },
				{ "7136@1@50" },
				{ "7013@1@50" },
				{ "7268@1@50" },
				{ "7220@1@150" },
				{ "10113@600@648" },
				{ "7301@301@400" },
				{ "7242@1@100" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogFaixaUopLineMapper(String line) throws Exception {
		LogFaixaUop logFaixaUop = logFaixaUopLineMapper.mapLine(line, 1);
		assertTrue(logFaixaUop.getUopNu() > 0);
		assertNotNull(logFaixaUop.getFncInicial());
		assertNotNull(logFaixaUop.getFncFinal());
	}

	@Test
	public void testValues() throws Exception {
		LogFaixaUop logFaixaUop = logFaixaUopLineMapper.mapLine("4329@1@100", 1);
		assertEquals(logFaixaUop.getUopNu(), new Integer(4329));
		assertEquals(logFaixaUop.getFncInicial(), new Integer(1));
		assertEquals(logFaixaUop.getFncFinal(), new Integer(100));
	}

}
