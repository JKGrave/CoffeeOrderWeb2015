package adminTest;

import kr.kosta.coffeeorder.dao.AdminDao;
import kr.kosta.coffeeorder.domain.Admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoUpdateAdminTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		Admin admin = dao.selectAdmin(2L);
		
		admin.setName("이준");
		
		admin.setAccount("lj@sk.kr");
		
		admin.setPassword("1234");
		
		admin.setPhoneNumber("010-0000-1234");
		
		admin.setEmail("lj@sk.kr");
		
		dao.updateAdmin(admin);
	}

}
