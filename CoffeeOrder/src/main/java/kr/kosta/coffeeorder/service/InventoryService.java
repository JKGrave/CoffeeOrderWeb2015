package kr.kosta.coffeeorder.service;

import java.util.List;

import kr.kosta.coffeeorder.domain.Inventory;

public interface InventoryService {
	
	public void registerInventory(Inventory inventory);
	public void modifyInventory(Inventory inventory);
	public void removeInventory(long id);
	public void removeInventory(List<Long> idList);
	public Inventory findInventory(long id);
	public List<Inventory> findInventory();
	public List<Inventory> findInventoryByStoreId(long storeId);
}
