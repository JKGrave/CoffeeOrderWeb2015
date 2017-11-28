package InventoryTest;

import java.util.ArrayList;
import java.util.List;

import kr.kosta.coffeeorder.dao.InventoryDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InventoryDaoDeleteInventoryListTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		InventoryDao dao = ctx.getBean(InventoryDao.class);
		
		List<Long> idList = new ArrayList<Long>();
		idList.add(5L);
		idList.add(6L);
		dao.deleteInventory(idList);
	}

}
