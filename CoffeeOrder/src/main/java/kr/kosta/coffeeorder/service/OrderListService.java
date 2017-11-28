package kr.kosta.coffeeorder.service;

import java.util.List;

import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Profit;

public interface OrderListService {

	public void registerOrderList(OrderList OrderList);
	
	public void setPayMember(long memberId);
	
	public void setPaymentStatus(long paymentId);
	
	public List<OrderList> findOrderLists(long storeId);
	public OrderList findOrderById(long id);
	public long findCoffeeCount(long id);
	public List<OrderList> findNonePayOrderLists(long storeId);
	
	public List<Code> findCodeByOption(String option);
	
	public Long findPrice(long StoreId);
	
	public List<Payment> findPayment();
	
	public List<Profit> findDayProfit(long storeId);
	public Long findDayTotalProfit(long storeId);
	
	public List<Profit> findMonthProfit(long storeId);
	public Long findMonthTotalProfit(long storeId);
	
	public List<Profit> findYearProfit(long stordId);
	public Long findYearTotalProfit(long stordId);

	public Long findOrdermember();

	public void receiveCheck(List<Long> idList);

	public void removeNonePayOrderList();
}
