package kr.kosta.coffeeorder.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.dao.StoreDao;
import kr.kosta.coffeeorder.dao.impl.mapper.StoreMapper;
import kr.kosta.coffeeorder.domain.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao
{
	@Autowired
	private StoreMapper storeMapper;


	@Override
	public List<Store> selectStores() {
		return this.storeMapper.selectStores();
	}

	@Override
	public Store selectStoreByName(String storeName) {
		return this.storeMapper.selectStoreByName(storeName);
	}

	@Override
	public Store selectStoreById(long storeId) {
		return this.storeMapper.selectStoreById(storeId);
	}

	@Override
	public int canOrder(long storeId, Date date)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storeId", storeId);
		map.put("date", date);
		return this.storeMapper.selectOrderCount(map);
	}

}
