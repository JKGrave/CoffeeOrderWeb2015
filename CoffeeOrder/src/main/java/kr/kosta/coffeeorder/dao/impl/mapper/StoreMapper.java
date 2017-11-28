package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Store;

public interface StoreMapper
{
	public List<Store> selectStores();
	
	public Store selectStoreByName(String storeName);
	
	public Store selectStoreById(long storeId);

	public int selectOrderCount(Map<String, Object> map);
}
