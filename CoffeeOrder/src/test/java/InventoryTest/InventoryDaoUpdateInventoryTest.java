package InventoryTest;

import kr.kosta.coffeeorder.dao.InventoryDao;
import kr.kosta.coffeeorder.domain.Inventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoUpdateInventoryTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		InventoryDao dao = ctx.getBean(InventoryDao.class);
		
		Inventory inventory = dao.selectInventory(2L);
		inventory.setStoreId(2);
		inventory.setName("업데이트테스트용");
		inventory.setAmount(4);
		dao.updateInventory(inventory);
	}

}
