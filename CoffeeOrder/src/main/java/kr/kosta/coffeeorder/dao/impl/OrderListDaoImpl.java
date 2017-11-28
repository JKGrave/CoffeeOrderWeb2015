package kr.kosta.coffeeorder.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kosta.coffeeorder.dao.OrderListDao;
import kr.kosta.coffeeorder.dao.impl.mapper.OrderListMapper;
import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Profit;

@Repository
public class OrderListDaoImpl implements OrderListDao {

	@Autowired
	private OrderListMapper orderMapper;

	@Override
	public void insertOrderList(OrderList orderList) {
		this.orderMapper.insertOrderList(orderList);
	}
	
	@Override
	public void updatePayMember(long memberId) {
		this.orderMapper.updateOrderMember(memberId);
	}

	@Override
	public void updatePayStatus(long paymentId) {
		this.orderMapper.updatePaymentStatus(paymentId);
	}
	@Override
	public List<OrderList> selectOrderLists(long storeId) {
		List<OrderList> orderList = this.orderMapper.selectOrderLists(storeId);
		return orderList;
	}
	
	@Override
	public OrderList selectOrderById(long id) {
		OrderList orderList = this.orderMapper.selectOrderById(id);
		return orderList;
	}

	@Override
	public long selectCoffeeCount(long id){
		long coffeeCount = this.orderMapper.selectCoffeeCount(id);
		return coffeeCount;
	}
	
	@Override
	public List<OrderList> selectNonePayOrderLists(long storeId) {
		List<OrderList> orderList = this.orderMapper.selectNonePayOrderLists(storeId);
		return orderList;
	}
	
	@Override
	public List<Code> selectCodeByOption(String option) {
		List<Code> optionCodes = this.orderMapper.selectCodeByOption(option);
		return optionCodes;
	}

	@Override
	public Long selectPrice(long StoreId) {
		Long price = this.orderMapper.selectPrice(StoreId);
		return price;
	}

	@Override
	public List<Payment> selectPayment() {
		List<Payment> payment = this.orderMapper.selectPayment();
		return payment;
	}


	@Override
	public Long selectOrderMember() {
		Long orderMember = this.orderMapper.selectOrderMember();
		return orderMember;
	}

	@Override
	public void updateReceiveCheck(List<Long> idList) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idList", idList);
		this.orderMapper.updateReceiveCheck(map);
	}

	@Override
	public void deleteNonePayOrderList() {
		this.orderMapper.deleteNonePayOrderList();
		
	}

	@Override
	public List<Profit> selectDayProfit(long storeId) {
		return this.orderMapper.selectDayProfit(storeId);
	}

	@Override
	public Long selectDayTotalProfit(long storeId) {
		return this.orderMapper.selectDayTotalProfit(storeId);
	}

	@Override
	public List<Profit> selectMonthProfit(long storeId) {
		return this.orderMapper.selectMonthProfit(storeId);
	}

	@Override
	public Long selectMonthTotalProfit(long storeId) {
		return this.orderMapper.selectMonthTotalProfit(storeId);
	}

	@Override
	public List<Profit> selectYearProfit(long storeId) {
		return this.orderMapper.selectYearProfit(storeId);
	}

	@Override
	public Long selectYearTotalProfit(long storeId) {
		return this.orderMapper.selectYearTotalProfit(storeId);
	}

	
	
	

	
	
	
}
