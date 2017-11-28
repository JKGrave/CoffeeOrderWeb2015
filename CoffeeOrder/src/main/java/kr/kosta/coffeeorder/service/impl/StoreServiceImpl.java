package kr.kosta.coffeeorder.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosta.coffeeorder.dao.StoreDao;
import kr.kosta.coffeeorder.domain.Store;
import kr.kosta.coffeeorder.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService
{
	@Autowired
	private StoreDao storeDao;

	@Override
	public List<Store> findStores()
	{
		// TODO Auto-generated method stub
		return this.storeDao.selectStores();
	}

	@Override
	public Store findStoreByName(String storeName)
	{
		return this.storeDao.selectStoreByName(storeName);
	}

	@Override
	public Store findStoreById(long storeId)
	{
		return this.storeDao.selectStoreById(storeId);
	}

	@Override
	public int canOrder(long storeId, Date date)
	{
		return this.storeDao.canOrder(storeId, date);
	}

}
