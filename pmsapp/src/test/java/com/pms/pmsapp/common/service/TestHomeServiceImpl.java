package com.pms.pmsapp.common.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.pmsapp.TestWithSpringBoot;
import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;
import com.pms.pmsapp.common.repository.ForexRepository;
import com.pms.pmsapp.common.repository.IndexRepository;
import com.pms.pmsapp.fixture.HomeFixture;
import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;

@TestInstance(Lifecycle.PER_CLASS)
public class TestHomeServiceImpl extends TestWithSpringBoot {

	@Autowired
	private HomeServiceImpl homeServiceImpl;

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
		indexRepository.deleteAll(indexList);
		forexRepository.deleteAll(forexList);
	}

	@Test
	public void testFindAllIndex() {

		List<Index> indexes = homeServiceImpl.findAllIndex();
		assertEquals(6, indexes.size());
	}

	@Test
	public void testFindAllForex() {

		List<Forex> forexes = homeServiceImpl.findAllForex();
		assertEquals(7, forexes.size());
	}

	@Test
	public void testFindIndexIsNotNull() throws IOException {
		StockWrapper stockWrapper1 = homeServiceImpl.findIndexOrForex("^GSPC");
		StockWrapper stockWrapper2 = homeServiceImpl.findIndexOrForex("^DJI");
		StockWrapper stockWrapper3 = homeServiceImpl.findIndexOrForex("^IXIC");
		StockWrapper stockWrapper4 = homeServiceImpl.findIndexOrForex("^HSI");
		StockWrapper stockWrapper5 = homeServiceImpl.findIndexOrForex("^STI");

		assertNotNull(stockWrapper1.getStock(), "Should not be null when finding with index symbol ^GSPC");
		assertNotNull(stockWrapper2.getStock(), "Should not be null when finding with index symbol ^DJI");
		assertNotNull(stockWrapper3.getStock(), "Should not be null when finding with index symbol ^IXIC");
		assertNotNull(stockWrapper4.getStock(), "Should not be null when finding with index symbol ^HSI");
		assertNotNull(stockWrapper5.getStock(), "Should not be null when finding with index symbol ^STI");
	}

	@Test
	public void testFindForexIsNotNull() throws IOException {
		StockWrapper stockWrapper1 = homeServiceImpl.findIndexOrForex("SGD=X");
		StockWrapper stockWrapper2 = homeServiceImpl.findIndexOrForex("SGDUSD=X");
		StockWrapper stockWrapper3 = homeServiceImpl.findIndexOrForex("HKDSGD=X");
		StockWrapper stockWrapper4 = homeServiceImpl.findIndexOrForex("SGDHKD=X");
		StockWrapper stockWrapper5 = homeServiceImpl.findIndexOrForex("HKD=X");
		StockWrapper stockWrapper6 = homeServiceImpl.findIndexOrForex("HKDUSD=X");

		assertNotNull(stockWrapper1.getStock(), "Should not be null when finding with currency symbol SGD=X");
		assertNotNull(stockWrapper2.getStock(), "Should not be null when finding with currency symbol SGDUSD=X");
		assertNotNull(stockWrapper3.getStock(), "Should not be null when finding with currency symbol HKDSGD=X");
		assertNotNull(stockWrapper4.getStock(), "Should not be null when finding with currency symbol SGDHKD=X");
		assertNotNull(stockWrapper5.getStock(), "Should not be null when finding with currency symbol HKD=X");
		assertNotNull(stockWrapper6.getStock(), "Should not be null when finding with currency symbol HKDUSD=X");
	}

	@Test
	public void testUpdateIndexLivePrices() {

		homeServiceImpl.updateLivePrices();

		List<Index> indexList = homeServiceImpl.findAllIndex();
		indexList.forEach(x -> {
			assertNotNull(x.getChange());
			assertNotNull(x.getChangePct());
			assertNotNull(x.getLast());
		});
	}

	@Test
	public void testUpdateForexLivePrices() {

		homeServiceImpl.updateLivePrices();

		List<Forex> forexList = homeServiceImpl.findAllForex();
		forexList.forEach(x -> {
			assertNotNull(x.getChange());
			assertNotNull(x.getChangePct());
			assertNotNull(x.getLast());
		});

	}

}
