package memberTest;

import java.util.List;

import kr.kosta.coffeeorder.dao.MemberDao;
import kr.kosta.coffeeorder.domain.Member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberSelectByPhoneNumber
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		MemberDao dao = ctx.getBean(MemberDao.class);
		
		List<Member> selectMembers = dao.selectMembers();
		
		for(Member m : selectMembers){
			System.out.println(m.getPhoneNumber());
			System.out.println(m.getName());
		}
//		010-9874-1234
//		010-9999-1234
//		010-8888-1234
		Member member = dao.selectMember("010-9874-1234");
		System.out.println(member.getName());
		System.out.println(member.getId());
		
	}

}
