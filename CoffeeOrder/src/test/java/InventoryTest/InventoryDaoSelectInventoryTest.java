package InventoryTest;

import kr.kosta.coffeeorder.dao.InventoryDao;
import kr.kosta.coffeeorder.domain.Inventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoSelectInventoryTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		InventoryDao dao = ctx.getBean(InventoryDao.class);
		
		Inventory inventory = dao.selectInventory(4L);
		
		System.out.println("id: " + inventory.getId() + ", storeId: " + inventory.getStoreId() + ", name : " + inventory.getName() + ", amount: " + inventory.getAmount());
	
	}
}
