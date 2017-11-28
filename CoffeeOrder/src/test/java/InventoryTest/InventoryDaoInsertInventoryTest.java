package InventoryTest;

import kr.kosta.coffeeorder.dao.InventoryDao;
import kr.kosta.coffeeorder.domain.Inventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoInsertInventoryTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		InventoryDao dao = ctx.getBean(InventoryDao.class);
		
		Inventory inventory = new Inventory();
		inventory.setStoreId(3);
		inventory.setName("저지방우유");
		inventory.setAmount(4);
		dao.insertInventory(inventory);
	}
}
