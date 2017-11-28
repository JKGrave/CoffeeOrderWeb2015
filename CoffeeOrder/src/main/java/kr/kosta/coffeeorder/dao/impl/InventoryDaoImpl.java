package kr.kosta.coffeeorder.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.dao.InventoryDao;
import kr.kosta.coffeeorder.dao.impl.mapper.InventoryMapper;
import kr.kosta.coffeeorder.domain.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class InventoryDaoImpl implements InventoryDao {
	
	@Autowired
	private InventoryMapper inventoryMapper;

	@Override
	public void insertInventory(Inventory inventory)
	{
		this.inventoryMapper.insertInventory(inventory);
	}

	@Override
	public void updateInventory(Inventory inventory)
	{
		this.inventoryMapper.updateInventory(inventory);
	}

	@Override
	public void deleteInventory(long id)
	{
		this.inventoryMapper.deleteInventory(id);
	}

	@Override
	public void deleteInventory(List<Long> idList)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idList", idList);
		this.inventoryMapper.deleteInventoryList(map);
	}

	@Override
	public Inventory selectInventory(long id)
	{
		Inventory inventory = inventoryMapper.selectInventory(id);
		return inventory;
	}

	@Override
	public List<Inventory> selectInventory()
	{
		List<Inventory> inventoryList = inventoryMapper.selectInventoryList();
		return inventoryList;
	}

	@Override
	public List<Inventory> selectInventoryByStoreId(long storeId) {
		List<Inventory> inventoryList = inventoryMapper.selectInventoryByStoreId(storeId);
		return inventoryList;
	}

}
