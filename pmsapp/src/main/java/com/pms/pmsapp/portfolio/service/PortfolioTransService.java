package com.pms.pmsapp.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pms.pmsapp.portfolio.data.MktExchg;
import com.pms.pmsapp.portfolio.data.Portfolio;
import com.pms.pmsapp.portfolio.data.PortfolioTrans;

public interface PortfolioTransService{
	public List<PortfolioTrans> findAll(long portId);
	public List<MktExchg> findAllMktExchg();
	public void addPortfolioTrans(PortfolioTrans portfolioTrans);
	public void deletePortfolioTrans(long id);
	public void populateToHolding(long id, long portId);
	public long getNextTransID();
	public int validateSellAction(PortfolioTrans portfolioTrans);
	public String findSuffix(String stockExchg);
	public int findCurrentStockHold(PortfolioTrans portfolioTrans);
}
