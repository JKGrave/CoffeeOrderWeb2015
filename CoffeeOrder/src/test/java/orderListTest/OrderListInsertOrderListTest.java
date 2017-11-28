package orderListTest;

import java.util.Date;

import kr.kosta.coffeeorder.dao.OrderListDao;
import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.Coffee;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderListInsertOrderListTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		OrderListDao dao = ctx.getBean(OrderListDao.class);
		
		OrderList order = new OrderList();
		
		Member member = new Member();
		member.setId(2L);
		order.setMember(member);
		
		Store store = new Store();
		store.setId(3L);
		order.setStore(store);
		
		Payment payment = new Payment();
		payment.setId(5L);
		order.setPayment(payment);
		
		Coffee coffee = new Coffee();
		coffee.setId(2L);
		order.setCoffee(coffee);
		
		Code whipping = new Code();
		whipping.setCode("1");
		order.setWhipping(whipping);
		
		Code syrup = new Code();
		syrup.setCode("3");
		order.setSyrup(syrup);
		
		Code shot = new Code();
		shot.setCode("1");
		order.setShot(shot);
		
		Code size = new Code();
		size.setCode("3");
		order.setSize(size);
		
		Code temp = new Code();
		temp.setCode("TEMP_ICE");
		order.setTemperature(temp);
		
		Code cup = new Code();
		cup.setCode("CUP_PAPER");
		order.setCup(cup);		
		
		order.setReceiveChk(false);
		order.setReceiveTime(new Date());
		
		dao.insertOrderList(order);
	}

}
