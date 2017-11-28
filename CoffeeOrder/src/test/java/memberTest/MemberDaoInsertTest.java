package memberTest;

import kr.kosta.coffeeorder.dao.MemberDao;
import kr.kosta.coffeeorder.domain.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberDaoInsertTest
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		MemberDao dao = ctx.getBean(MemberDao.class);
		
		Member m = new Member();
		
		m.setName("황진규");
		m.setPassword("1234");
		m.setPhoneNumber("010-9120-5923");
		m.setDeviceId("asdf");
		m.setDiscountCard(1L);
		m.setPreferenceStore(1L);
		
		dao.insertMember(m);

	}

}
