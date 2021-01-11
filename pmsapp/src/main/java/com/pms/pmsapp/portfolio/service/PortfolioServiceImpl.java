package com.pms.pmsapp.portfolio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.pmsapp.portfolio.dao.PortfolioDao;
import com.pms.pmsapp.portfolio.data.Portfolio;

@Service
public class PortfolioServiceImpl implements PortfolioService {
	
	private static final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);
	
	@Autowired
	private PortfolioDao portfolioDao;
	
	public PortfolioDao getPortfolioDao() {
		return portfolioDao;
	}

	public void setPortfolioDao(PortfolioDao portfolioDao) {
		this.portfolioDao = portfolioDao;
	}

	public List<Portfolio> findAll(){
		log.info("findAll in ServiceImpl");
		return portfolioDao.findAll();
	}
	
	public void addPortfolio(Portfolio portfolioForm) {
		portfolioDao.addPortfolio(portfolioForm);
	}
	
	public Portfolio updatePortfolio(Portfolio portfolioForm) {
		return portfolioDao.updatePortfolio(portfolioForm);
	}
	
	public void deletePortfolio(long id) {
		portfolioDao.deletePortfolio(id);
	}
	
	public boolean checkPortfolioExist(String portfolioName) {
		return portfolioDao.checkPortfolioExist(portfolioName);
	}
	
	public boolean checkPortfolioExist(Long portfolioId, String portfolioName) {
		return portfolioDao.checkPortfolioExist(portfolioId, portfolioName);
	}
	
}
