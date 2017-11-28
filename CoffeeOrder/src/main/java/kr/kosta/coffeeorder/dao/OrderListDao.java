package kr.kosta.coffeeorder.dao;

import java.util.List;

import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Profit;

public interface OrderListDao {

	public void insertOrderList(OrderList orderList);
	
	public void updatePayMember(long memberId);
	
	public void updatePayStatus(long paymentId);
	
	public List<OrderList> selectOrderLists(long storeId);
	public OrderList selectOrderById(long id);
	public long selectCoffeeCount(long id);
	public List<OrderList> selectNonePayOrderLists(long storeId);
	
	public List<Code> selectCodeByOption(String option);
	
	public Long selectPrice(long StoreId);
	
	public List<Payment> selectPayment();
	
	public Long selectOrderMember();

	public void updateReceiveCheck(List<Long> idList);

	public void deleteNonePayOrderList();

	public List<Profit> selectDayProfit(long storeId);

	public Long selectDayTotalProfit(long storeId);

	public List<Profit> selectMonthProfit(long storeId);

	public Long selectMonthTotalProfit(long storeId);

	public List<Profit> selectYearProfit(long storeId);

	public Long selectYearTotalProfit(long storeId);

}
