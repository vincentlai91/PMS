package com.pms.pmsapp.profitloss.dao;

import com.pms.pmsapp.manageportfolio.portfolio.data.StockWrapper;
import com.pms.pmsapp.profitloss.data.RealPL;
import com.pms.pmsapp.profitloss.data.RealTotalPL;
import com.pms.pmsapp.profitloss.data.UnrealPL;
import com.pms.pmsapp.profitloss.data.UnrealTotalPL;

import java.util.List;

public interface ProfitLossDao{

	List<String> getPortfolios();
	List<String> getAllCurr();
	List<UnrealPL> getUnrealisedList(long portId);
	void computeUnrealisedList(String portfolio, String currency);
	List<RealPL> getRealisedList(String portfolio, String currency);
	void computeRealisedList(String portfolio, String currency);
	UnrealTotalPL getUnrealisedTotalList(String portfolio);
	RealTotalPL getRealisedTotalList(String portfolio);
	StockWrapper findStock(String stockSym);
	void updateLastVal(UnrealPL unrealPl);

}
