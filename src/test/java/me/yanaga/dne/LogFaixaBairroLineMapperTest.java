package me.yanaga.dne;

import me.yanaga.dne.config.root.BatchConfig;
import me.yanaga.dne.app.bean.LogFaixaBairro;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogFaixaBairroLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogFaixaBairro> logFaixaBairroLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "52387@13349700@13349749" },
				{ "52388@12051830@12051849" },
				{ "52389@13275700@13275739" },
				{ "15058@12952770@12952789" },
				{ "15097@12952720@12952729" },
				{ "17977@14402400@14402478" },
				{ "30156@13611750@13611789" },
				{ "30157@13613410@13613429" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogFaixaBairroLineMapper(String line) throws Exception {
		LogFaixaBairro logFaixaBairro = logFaixaBairroLineMapper.mapLine(line, 1);
		assertTrue(logFaixaBairro.getBaiNu() > 0);
		assertTrue(logFaixaBairro.getFcbCepIni().matches("\\d{8}"));
		assertTrue(logFaixaBairro.getFcbCepFim().matches("\\d{8}"));
	}

	@Test
	public void testValues() throws Exception {
		LogFaixaBairro logFaixaBairro = logFaixaBairroLineMapper.mapLine("52387@13349700@13349749", 1);
		assertEquals(logFaixaBairro.getBaiNu(), new Integer(52387));
		assertEquals(logFaixaBairro.getFcbCepIni(), "13349700");
		assertEquals(logFaixaBairro.getFcbCepFim(), "13349749");
	}

}
