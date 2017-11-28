package adminTest;

import kr.kosta.coffeeorder.dao.AdminDao;
import kr.kosta.coffeeorder.domain.Admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoSelectAdminTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"test-applicationContext.xml");

		AdminDao dao = ctx.getBean(AdminDao.class);

		Admin admin = dao.selectAdmin(1L);

		System.out.println("id:" + admin.getId() + ", store_id:"
				+ admin.getStore().getName() + admin.getStore().getId() + ", name:" + admin.getName()
				+ ", account:" + admin.getAccount() + ", password:"
				+ admin.getPassword() + ", phone_number:"
				+ admin.getPhoneNumber() + ", email:" + admin.getEmail());
	}

}
