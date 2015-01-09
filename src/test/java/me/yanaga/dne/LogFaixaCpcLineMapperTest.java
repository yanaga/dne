package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.config.root.BatchConfig;
import me.yanaga.dne.app.bean.LogFaixaCpc;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogFaixaCpcLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogFaixaCpc> logFaixaCpcLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "2158@1@108" },
				{ "2158@109@216" },
				{ "2159@1@108" },
				{ "2161@1@108" },
				{ "2161@109@216" },
				{ "2161@217@324" },
				{ "2162@1@108" },
				{ "2187@1@108" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogFaixaCpcLineMapper(String line) throws Exception {
		LogFaixaCpc logFaixaCpc = logFaixaCpcLineMapper.mapLine(line, 1);
		assertTrue(logFaixaCpc.getCpcNu() > 0);
		assertTrue(!Strings.isNullOrEmpty(logFaixaCpc.getCpcInicial()));
		assertTrue(!Strings.isNullOrEmpty(logFaixaCpc.getCpcFinal()));
	}

	@Test
	public void testValues() throws Exception {
		LogFaixaCpc logFaixaCpc = logFaixaCpcLineMapper.mapLine("2158@1@108", 1);
		assertEquals(logFaixaCpc.getCpcNu(), new Integer(2158));
		assertEquals(logFaixaCpc.getCpcInicial(), "1");
		assertEquals(logFaixaCpc.getCpcFinal(), "108");
	}

}
