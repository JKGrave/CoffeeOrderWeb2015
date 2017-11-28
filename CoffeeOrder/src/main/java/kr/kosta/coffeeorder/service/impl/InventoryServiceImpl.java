package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import kr.kosta.coffeeorder.dao.InventoryDao;
import kr.kosta.coffeeorder.domain.Inventory;
import kr.kosta.coffeeorder.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public void registerInventory(Inventory inventory)
	{
		this.inventoryDao.insertInventory(inventory);
	}

	@Override
	public void modifyInventory(Inventory inventory)
	{
		this.inventoryDao.updateInventory(inventory);
	}

	@Override
	public void removeInventory(long id)
	{
		this.inventoryDao.deleteInventory(id);
	}

	@Override
	public void removeInventory(List<Long> idList)
	{
		this.inventoryDao.deleteInventory(idList);
	}

	@Override
	public Inventory findInventory(long id)
	{
		return this.inventoryDao.selectInventory(id);
	}

	@Override
	public List<Inventory> findInventory()
	{
		return this.inventoryDao.selectInventory();
	}

	@Override
	public List<Inventory> findInventoryByStoreId(long storeId) {
		return this.inventoryDao.selectInventoryByStoreId(storeId);
	}

}
