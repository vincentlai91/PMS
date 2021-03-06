package com.pms.pmsapp.common.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.pms.pmsapp.PmsappApplication;
import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.repository.ForexRepository;
import com.pms.pmsapp.common.repository.IndexRepository;
import com.pms.pmsapp.common.repository.dao.HomeDaoImpl;
import com.pms.pmsapp.fixture.HomeFixture;

@DataJpaTest
@ContextConfiguration(classes = { HomeDaoImpl.class, PmsappApplication.class })
@TestInstance(Lifecycle.PER_CLASS)
public class TestHomeRepository {

	@Autowired
	private HomeDaoImpl homeDaoImpl;

	@Autowired
	private IndexRepository indexRepository;

	@Autowired
	private ForexRepository forexRepository;

	private List<Index> indexList;
	private List<Forex> forexList;

	@BeforeAll
	public void setup() throws Exception {

		indexList = HomeFixture.createIndexListFixture();
		forexList = HomeFixture.createForexListFixture();

		indexRepository.saveAll(indexList);
		forexRepository.saveAll(forexList);

	}

	@AfterAll
	public void teardown() throws Exception {
		indexRepository.deleteAll();
		forexRepository.deleteAll();
	}

	@Test
	public void testUpdateLastValIndex() {

		Index indexFixture = indexList.get(0);
		indexFixture.setLast(new BigDecimal("4005.92"));
		indexFixture.setChange(new BigDecimal("-122.96"));
		indexFixture.setChangePct(new BigDecimal("-2.87"));

		indexRepository.save(indexFixture);
		Optional<Index> index = indexRepository.findById(1L);
		assertEquals(new BigDecimal("4005.92"), index.get().getLast());
		assertEquals(new BigDecimal("-122.96"), index.get().getChange());
		assertEquals(new BigDecimal("-2.87"), index.get().getChangePct());

	}

	@Test
	public void testUpdateLastValForex() {

		Forex forexFixture = forexList.get(0);
		forexFixture.setLast(new BigDecimal("1.4215"));
		forexFixture.setChange(new BigDecimal("-0.0055"));
		forexFixture.setChangePct(new BigDecimal("-0.45"));
		forexRepository.save(forexFixture);

		Forex forex = forexRepository.findById(1L).orElse(null);
		assertEquals(new BigDecimal("1.4215"), forex.getLast());
		assertEquals(new BigDecimal("-0.0055"), forex.getChange());
		assertEquals(new BigDecimal("-0.45"), forex.getChangePct());

	}

}
