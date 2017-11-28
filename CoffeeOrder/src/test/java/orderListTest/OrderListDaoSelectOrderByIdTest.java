package orderListTest;

import kr.kosta.coffeeorder.dao.OrderListDao;
import kr.kosta.coffeeorder.domain.OrderList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class OrderListDaoSelectOrderByIdTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		OrderListDao dao = ctx.getBean(OrderListDao.class);
		
		OrderList order = dao.selectOrderById(1L);
		
		System.out.println(order.getId()+order.getCoffee().getName());
	}

}
