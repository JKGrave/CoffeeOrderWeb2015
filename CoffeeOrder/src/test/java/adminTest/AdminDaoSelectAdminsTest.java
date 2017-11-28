package adminTest;

import java.util.ArrayList;
import java.util.List;

import kr.kosta.coffeeorder.dao.AdminDao;
import kr.kosta.coffeeorder.domain.Admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoSelectAdminsTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"test-applicationContext.xml");

		AdminDao dao = ctx.getBean(AdminDao.class);
		
		List<Admin> admins = dao.selectAdmins(); 
		
		for(Admin admin : admins) {
		System.out.println("id:" + admin.getId() + ", store_id:"
				+ admin.getStore() + ", name:" + admin.getName()
				+ ", account:" + admin.getAccount() + ", password:"
				+ admin.getPassword() + ", phone_number:"
				+ admin.getPhoneNumber() + ", email:" + admin.getEmail());
		}
	}

}
