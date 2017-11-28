package kr.kosta.coffeeorder.dao;

import java.util.List;

import kr.kosta.coffeeorder.domain.Inventory;

public interface InventoryDao {
	
	public void insertInventory(Inventory inventory);
	public void updateInventory(Inventory inventory);
	public void deleteInventory(long id);
	public void deleteInventory(List<Long> idList);
	public Inventory selectInventory(long id);
	public List<Inventory> selectInventory();
	public List<Inventory> selectInventoryByStoreId(long storeId);
}
