package kr.kosta.coffeeorder.service;

import java.util.Date;
import java.util.List;

import kr.kosta.coffeeorder.domain.Store;

public interface StoreService
{
	public List<Store> findStores();
	
	public Store findStoreByName(String storeName);
	
	public Store findStoreById(long storeId);

	public int canOrder(long storeId, Date date);
}
