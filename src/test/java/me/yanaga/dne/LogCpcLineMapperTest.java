package me.yanaga.dne;

import com.google.common.base.Strings;
import me.yanaga.dne.sqlite.bean.LogCpc;
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
public class LogCpcLineMapperTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private LineMapper<LogCpc> logCpcLineMapper;

	@DataProvider(name = "lines")
	public static Object[][] lines() {
		return new Object[][] {
				{ "3872@AC@16@Benfica@Ramal Benfica, s/n@69902992" },
				{ "1285@AL@158@Conjunto Mutirão@Quadra 1 nº 37 - Conj.Mutirão - Rio Largo@57100990" },
				{ "3788@AL@158@Utinga Leão@Rua do Hospital s/n@57100993" },
				{ "4162@AL@184@Gulandim@Povoado Gulandim@57265990" },
				{ "4191@AL@144@Pontal do Peba@Povoado Pontal do Peba@57210990" },
				{ "4195@AL@145@Mangabeiras@Povoado Mangabeiras@57150990" },
				{ "4197@AL@30@Pau D'Arco@Povoado Pau D'Arco@57319990" },
				{ "4199@AL@31@Vila José Paulino@Rua Professor Genário Cardoso s/n@57690990" }
		};
	}

	@Test(dataProvider = "lines")
	public void testLogCpcLineMaper(String line) throws Exception {
		LogCpc logCpc = logCpcLineMapper.mapLine(line, 1);
		assertTrue(logCpc.getCpcNu() > 0);
		assertTrue(logCpc.getUfeSg().matches("[a-zA-Z]{2}"));
		assertNotNull(logCpc.getLocNu());
		assertTrue(!Strings.isNullOrEmpty(logCpc.getCpcNo()));
		assertTrue(!Strings.isNullOrEmpty(logCpc.getCpcEndereco()));
		assertTrue(logCpc.getCep().matches("\\d{8}"));
	}

	@Test
	public void testValues() throws Exception {
		LogCpc logCpc = logCpcLineMapper.mapLine("3872@AC@16@Benfica@Ramal Benfica, s/n@69902992", 1);
		assertEquals(logCpc.getCpcNu(), new Integer(3872));
		assertEquals(logCpc.getUfeSg(), "AC");
		assertEquals(logCpc.getLocNu(), new Integer(16));
		assertEquals(logCpc.getCpcNo(), "Benfica");
		assertEquals(logCpc.getCpcEndereco(), "Ramal Benfica, s/n");
		assertEquals(logCpc.getCep(), "69902992");
	}

}
