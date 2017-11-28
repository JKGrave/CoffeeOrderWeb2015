package memberTest;

import kr.kosta.coffeeorder.dao.MemberDao;
import kr.kosta.coffeeorder.domain.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberDaoUpdate {

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		MemberDao dao = ctx.getBean(MemberDao.class);
		
		Member m = dao.selectMember("010-9120-5923");
		
		m.setName("뀨뀨");
		m.setPassword("4321");
		
		dao.updateMember(m);
		
		
	}
	
}
