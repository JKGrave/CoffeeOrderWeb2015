package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Inventory;

public interface InventoryMapper {
	public void insertInventory(Inventory inventory);
	public void updateInventory(Inventory inventory);
	public void deleteInventory(long id);
	public void deleteInventoryList(Map<String, Object> map);
	public Inventory selectInventory(long id);
	public List<Inventory> selectInventoryList();
	public List<Inventory> selectInventoryByStoreId(long storeId);

}
