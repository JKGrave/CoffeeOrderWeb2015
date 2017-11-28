package storetest;

import java.util.List;

import kr.kosta.coffeeorder.dao.StoreDao;
import kr.kosta.coffeeorder.domain.Store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StoreTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		StoreDao dao = ctx.getBean(StoreDao.class);

		List<Store> stores = dao.selectStores();
		for (Store store : stores)
		{
			System.out.println(store.getName());
		}

		Store s = dao.selectStoreById(1L);
		System.out.println(s.getName());
		
		Store st = dao.selectStoreByName("서경대점");
		System.out.println(st.getId());

	}

}
