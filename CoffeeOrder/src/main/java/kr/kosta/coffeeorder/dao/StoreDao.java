package kr.kosta.coffeeorder.dao;

import java.util.Date;
import java.util.List;

import kr.kosta.coffeeorder.domain.Store;

public interface StoreDao
{
	public List<Store> selectStores();
	
	public Store selectStoreByName(String storeName);
	
	public Store selectStoreById(long storeId);

	public int canOrder(long storeId, Date date);
}
