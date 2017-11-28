package InventoryTest;

import kr.kosta.coffeeorder.dao.InventoryDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoDeleteInventoryTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		InventoryDao dao = ctx.getBean(InventoryDao.class);
		
		dao.deleteInventory(1L);
	}

}
