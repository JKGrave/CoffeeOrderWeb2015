package MenuTest;

import kr.kosta.coffeeorder.dao.MenuDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuDaoDeleteMenuTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		MenuDao dao = ctx.getBean(MenuDao.class);
		
		dao.deleteMenu(8L);
	}

}
