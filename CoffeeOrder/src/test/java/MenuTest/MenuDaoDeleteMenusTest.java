package MenuTest;

import java.util.ArrayList;
import java.util.List;

import kr.kosta.coffeeorder.dao.MenuDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuDaoDeleteMenusTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		MenuDao dao = ctx.getBean(MenuDao.class);
		
		List<Long> idList = new ArrayList<Long>();
		
		idList.add(9L);
		idList.add(10L);
		
		dao.deleteMenus(idList);
	}

}
