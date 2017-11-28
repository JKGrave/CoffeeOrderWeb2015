package memberTest;

import kr.kosta.coffeeorder.dao.MemberDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberDaoDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		MemberDao dao = ctx.getBean(MemberDao.class);
		
		dao.deleteMember("010-9120-5923");

	}

}
