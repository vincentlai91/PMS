package com.pms.pmsapp.fixture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pms.pmsapp.common.data.Forex;
import com.pms.pmsapp.common.data.Index;

public class HomeFixture {

//	public static Index createIndexFixture() {
//		Index index = new Index(6L, "^GSPC", "S&P 500", new BigDecimal(3911.74), new BigDecimal(116.01),
//				new BigDecimal(3.06), new Date());
//		return index;
//	}
//
//	public static Forex createForexFixture() {
//		Forex forex = new Forex(6L, "USD/SGD", "SGD=X", "Forex Rate: USD to SGD", new BigDecimal(1.3855),
//				new BigDecimal(-0.0046), new BigDecimal(-0.33), "=X", new Date());
//		return forex;
//	}

	public static List<Index> createIndexListFixture() {

		List<Index> indexList = new ArrayList<>();
		indexList.add(new Index(1L, "^GSPC", "S&P 500", new BigDecimal(3911.74), new BigDecimal(116.01),
				new BigDecimal(3.06), new Date()));
		indexList.add(new Index(2L, "^DJI", "Dow Jones Industrial Average", new BigDecimal(31500.68),
				new BigDecimal(823.32), new BigDecimal(2.68), new Date()));
		indexList.add(new Index(3L, "^IXIC", "NASDAQ Composite", new BigDecimal(11607.62), new BigDecimal(375.428),
				new BigDecimal(3.34), new Date()));
		indexList.add(new Index(4L, "^HSI", "Hang Seng Index", new BigDecimal(21719.06), new BigDecimal(445.19),
				new BigDecimal(2.09), new Date()));
		indexList.add(new Index(5L, "^STI", "Straits Times Index", new BigDecimal(3111.65), new BigDecimal(18.85),
				new BigDecimal(0.61), new Date()));

		return indexList;
	}

	public static List<Forex> createForexListFixture() {

		List<Forex> forexList = new ArrayList<>();
		forexList.add(new Forex(1L, "USD/SGD", "SGD=X", "Forex Rate: USD to SGD", new BigDecimal(1.3855),
				new BigDecimal(-0.0046), new BigDecimal(-0.33), "=X", new Date()));
		forexList.add(new Forex(2L, "SGD/USD", "SGDUSD=X", "Forex Rate: SGD to USD", new BigDecimal(0.7217611),
				new BigDecimal(0.0023884), new BigDecimal(0.33), "=X", new Date()));
		forexList.add(new Forex(3L, "HKD/SGD", "HKDSGD=X", "Forex Rate: HKD to SGD", new BigDecimal(0.17651),
				new BigDecimal(-0.00056), new BigDecimal(-0.32), "=X", new Date()));
		forexList.add(new Forex(4L, "SGD/HKD", "SGDHKD=X", "Forex Rate: SGD to HKD", new BigDecimal(5.6621),
				new BigDecimal(0.0211), new BigDecimal(0.37), "=X", new Date()));
		forexList.add(new Forex(5L, "USD/HKD", "HKD=X", "Forex Rate: USD to HKD", new BigDecimal(7.8489),
				new BigDecimal(-0.0002), new BigDecimal(0), "=X", new Date()));
		forexList.add(new Forex(6L, "HKD/USD", "HKDUSD=X", "Forex Rate: HKD to USD", new BigDecimal(0.12740639),
				new BigDecimal(0.00000325), new BigDecimal(0), "=X", new Date()));

		return forexList;
	}

}
