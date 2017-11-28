package InventoryTest;

import java.util.List;

import kr.kosta.coffeeorder.dao.InventoryDao;
import kr.kosta.coffeeorder.domain.Inventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoSelectInventoryListTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		InventoryDao dao = ctx.getBean(InventoryDao.class);
		
		List<Inventory> inventoryList = dao.selectInventory();
		for(Inventory inventory : inventoryList) {
			System.out.println("id: " + inventory.getId() + ", storeId: " + inventory.getStoreId() + ", name : " + inventory.getName() + ", amount: " + inventory.getAmount());
		}		
	}

}
