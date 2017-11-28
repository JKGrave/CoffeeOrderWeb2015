package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Profit;

public interface OrderListMapper {

	public void insertOrderList(OrderList orderList);
	
	public void updateOrderMember(long memberId);

	public void updatePaymentStatus(long paymentId);

	public List<OrderList> selectOrderLists(long storeId);

	public OrderList selectOrderById(long id);
	public long selectCoffeeCount(long id);
	public List<OrderList> selectNonePayOrderLists(long storeId);

	public List<Code> selectCodeByOption(String option);
	
	public Long selectPrice(long StoreId);
	
	public List<Payment> selectPayment();

	public List<Profit> selectDayProfit(long storeId);
	public Long selectDayTotalProfit(long storeId);

	public List<Profit> selectMonthProfit(long storeId);
	public Long selectMonthTotalProfit(long storeId);
	
	public List<Profit> selectYearProfit(long storeId);
	public Long selectYearTotalProfit(long storeId);
	
	public Long selectOrderMember();

	public void updateReceiveCheck(Map<String, Object> map);

	public void deleteNonePayOrderList();


}
