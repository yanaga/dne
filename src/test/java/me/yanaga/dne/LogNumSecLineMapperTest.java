package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.app.BatchConfig;
import me.yanaga.dne.sqlite.bean.LogNumSec;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogNumSecLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogNumSec> logNumSecLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "172547@1000@2289@A" },
				{ "172550@1@1125@A" },
				{ "172551@1126@99999@A" },
				{ "172631@1@899@A" },
				{ "172653@1@1177@A" },
				{ "172654@1178@99999@A" },
				{ "172733@1@0932@A" },
				{ "172734@0933@1810@A" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogNumSecLineMaper(String line) throws Exception {
		LogNumSec logNumSec = logNumSecLineMapper.mapLine(line, 1);
		assertTrue(logNumSec.getLogNu() > 0);
		assertTrue(!Strings.isNullOrEmpty(logNumSec.getSecNuIni()));
		assertTrue(!Strings.isNullOrEmpty(logNumSec.getSecNuFim()));
		assertTrue(logNumSec.getSecInLado().matches("[apideAPIDE]"));
	}

	@Test
	public void testValues() throws Exception {
		LogNumSec logNumSec = logNumSecLineMapper.mapLine("172547@1000@2289@A", 1);
		assertEquals(logNumSec.getLogNu(), new Integer(172547));
		assertEquals(logNumSec.getSecNuIni(), "1000");
		assertEquals(logNumSec.getSecNuFim(), "2289");
		assertEquals(logNumSec.getSecInLado(), "A");
	}

}
