package com.pms.pmsapp.manageportfolio.portfolio.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pms.pmsapp.manageportfolio.portfolio.data.Portfolio;

public interface PortfolioService{
	public List<Portfolio> findAll(Pageable pageable);
	public void addPortfolio(Portfolio portfolioForm);
	public Portfolio updatePortfolio(Portfolio portfolioForm);
	public void deletePortfolio(long id);
	public boolean checkPortfolioExist(String portfolioName);
	public boolean checkPortfolioExist(Long portfolioId, String portfolioName);
	public long findAllCount();
	public long getPortIdFromPortName(String portfolioName);
}