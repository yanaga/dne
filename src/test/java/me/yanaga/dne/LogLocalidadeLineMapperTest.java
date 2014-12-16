package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.sqlite.bean.LogLocalidade;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = BatchConfig.class)
public class LogLocalidadeLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogLocalidade> logLocalidadeLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "1@AC@Acrelândia@69945000@0@M@@Acrelândia@1200013" },
				{ "11059@AC@Campinas@69929000@0@D@13@Campinas@" },
				{ "3@AC@Brasiléia@69932000@0@M@@Brasiléia@1200104" },
				{ "4@AC@Bujari@69926000@0@M@@Bujari@1200138" },
				{ "5@AC@Capixaba@69931000@0@M@@Capixaba@1200179" },
				{ "6@AC@Cruzeiro do Sul@69980000@0@M@@Cruzeiro Sul@1200203" },
				{ "7@AC@Epitaciolândia@69934000@0@M@@Epitaciolândia@1200252" },
				{ "8@AC@Feijó@69960000@0@M@@Feijó@1200302" },
				{ "9862@TO@Gurupi@@1@M@@Gurupi@1709500" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogLocalidadeLineMaper(String line) throws Exception {
		LogLocalidade logLocalidade = logLocalidadeLineMapper.mapLine(line, 1);
		assertTrue(logLocalidade.getLocNu() > 0);
		assertTrue(logLocalidade.getUfeSg().matches("[a-zA-Z]{2}"));
		assertNotNull(logLocalidade.getLocNo());
		assertTrue(Strings.isNullOrEmpty(logLocalidade.getCep()) || logLocalidade.getCep().matches("\\d{8}"));
		assertTrue(logLocalidade.getLocInSit().matches("[012]"));
		assertTrue(logLocalidade.getLocInTipoLoc().matches("[dmpDMP]"));
		assertTrue(Strings.isNullOrEmpty(logLocalidade.getMunNu()) || logLocalidade.getMunNu().matches("\\d{7}"));
	}

	@Test
	public void testValues() throws Exception {
		LogLocalidade logLocalidade = logLocalidadeLineMapper.mapLine("1@AC@Acrelândia@69945000@0@M@@Acrelândia@1200013", 1);
		assertEquals(logLocalidade.getLocNu(), new Integer(1));
		assertEquals(logLocalidade.getUfeSg(), "AC");
		assertEquals(logLocalidade.getLocNo(), "Acrelândia");
		assertEquals(logLocalidade.getCep(), "69945000");
		assertEquals(logLocalidade.getLocInSit(), "0");
		assertEquals(logLocalidade.getLocInTipoLoc(), ("M"));
		assertNull(logLocalidade.getLocNuSub());
		assertEquals(logLocalidade.getLocNoAbrev(), "Acrelândia");
		assertEquals(logLocalidade.getMunNu(), "1200013");
	}

}
