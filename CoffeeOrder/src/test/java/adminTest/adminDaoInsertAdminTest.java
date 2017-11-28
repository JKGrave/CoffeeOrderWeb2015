package adminTest;

import kr.kosta.coffeeorder.dao.AdminDao;
import kr.kosta.coffeeorder.domain.Admin;
import kr.kosta.coffeeorder.domain.Store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class adminDaoInsertAdminTest {
	
	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		AdminDao dao = ctx.getBean(AdminDao.class);
		
		Admin admin = new Admin();
		
		admin.setStore(new Store());
		admin.setName("추가된사람");
		admin.setAccount("login");
		admin.setPassword("1234");
		admin.setPhoneNumber("1234");
		admin.setEmail("abc@sk.kr");
		dao.insertAdmin(admin);
	}
}
