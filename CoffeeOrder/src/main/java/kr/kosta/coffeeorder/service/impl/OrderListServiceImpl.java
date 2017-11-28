package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosta.coffeeorder.dao.OrderListDao;
import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Profit;
import kr.kosta.coffeeorder.service.OrderListService;

@Service
public class OrderListServiceImpl implements OrderListService {

	@Autowired
	private OrderListDao orderListdao;
	
	@Override
	public void registerOrderList(OrderList orderList) {
		this.orderListdao.insertOrderList(orderList);
	}
	
	@Override
	public void setPayMember(long memberId) {
		this.orderListdao.updatePayMember(memberId);
		
	}
	
	@Override
	public void setPaymentStatus(long paymentId) {
		this.orderListdao.updatePayStatus(paymentId);
	}

	@Override
	public List<OrderList> findOrderLists(long storeId) {
		return this.orderListdao.selectOrderLists(storeId);
	}
	@Override
	public OrderList findOrderById(long id) {
		return this.orderListdao.selectOrderById(id);
	}

	@Override
	public long findCoffeeCount(long id) {
		return this.orderListdao.selectCoffeeCount(id);
	}

	@Override
	public List<OrderList> findNonePayOrderLists(long storeId) {
		return this.orderListdao.selectNonePayOrderLists(storeId);
	}

	@Override
	public List<Code> findCodeByOption(String option) {
		return this.orderListdao.selectCodeByOption(option);
	}

	@Override
	public Long findPrice(long StoreId) {
		return this.orderListdao.selectPrice(StoreId);
	}

	@Override
	public List<Payment> findPayment() {
		return this.orderListdao.selectPayment();
	}


	@Override
	public Long findOrdermember() {
		return this.orderListdao.selectOrderMember();
	}

	@Override
	public void receiveCheck(List<Long> idList) {
		
		this.orderListdao.updateReceiveCheck(idList);
	}

	@Override
	public void removeNonePayOrderList() {
		this.orderListdao.deleteNonePayOrderList();
	}

	@Override
	public List<Profit> findDayProfit(long storeId) {
		return this.orderListdao.selectDayProfit(storeId);
	}

	@Override
	public Long findDayTotalProfit(long storeId) {
		return this.orderListdao.selectDayTotalProfit(storeId);
	}

	@Override
	public List<Profit> findMonthProfit(long storeId) {
		return this.orderListdao.selectMonthProfit(storeId);
	}

	@Override
	public Long findYearTotalProfit(long stordId) {
		return this.orderListdao.selectMonthTotalProfit(stordId);
	}
	
	@Override
	public List<Profit> findYearProfit(long storeId) {
		return this.orderListdao.selectYearProfit(storeId);
	}
	
	@Override
	public Long findMonthTotalProfit(long storeId) {
		return this.orderListdao.selectYearTotalProfit(storeId);
	}



}
