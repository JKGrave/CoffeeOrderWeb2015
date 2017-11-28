package orderListTest;

import java.util.List;

import kr.kosta.coffeeorder.dao.OrderListDao;
import kr.kosta.coffeeorder.domain.OrderList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderListSelectOrderListTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		OrderListDao dao = ctx.getBean(OrderListDao.class);
		
		List<OrderList> orderLists = dao.selectOrderLists(1L);
		
		for(OrderList orderList : orderLists){
			System.out.println("id : " + orderList.getId() + ", 회원 : " + orderList.getMember().getName()
					+ ", 매장 : " + orderList.getStore().getName() + ", 결제방식 : " + orderList.getPayment().getName()
					+ ", 커피 : " + orderList.getCoffee().getName() + ", 가격 : " + orderList.getCoffee().getPrice()
					+ ", 샷 : " + orderList.getShot().getName() + ", 사이즈 : " + orderList.getSize().getName()
					+ ", 휘핑 : " + orderList.getWhipping().getName() + ", 시럽 : " + orderList.getSyrup().getName()
					+ ", 온도 : " + orderList.getTemperature().getName() +  ", 컵 : " + orderList.getCup().getName() 
					+ ", 수령여부 : " + orderList.isReceiveChk() + ", 수령시간 : " + orderList.getReceiveTime()					
			);
		}
	}
}
