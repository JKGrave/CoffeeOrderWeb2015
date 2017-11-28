package adminTest;

import java.util.ArrayList;
import java.util.List;

import kr.kosta.coffeeorder.dao.AdminDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoDeleteAdminsTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		List<Long> idList = new ArrayList<Long>();
		
		idList.add(5L);
		idList.add(7L);
		
		dao.deleteAdmins(idList);
	}

}
