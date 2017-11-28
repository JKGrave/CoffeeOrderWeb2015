package adminTest;

import kr.kosta.coffeeorder.dao.AdminDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoDeleteAdminTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		dao.deleteAdmin(4L);
	}

}
