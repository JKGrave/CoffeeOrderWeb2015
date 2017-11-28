package kr.kosta.coffeeorder.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.Coffee;
import kr.kosta.coffeeorder.domain.CoffeeType;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.Profit;
import kr.kosta.coffeeorder.domain.Store;
import kr.kosta.coffeeorder.service.CoffeeService;
import kr.kosta.coffeeorder.service.MemberService;
import kr.kosta.coffeeorder.service.OrderListService;
import memberTest.MemberPushTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;


@Controller
@RequestMapping("order")
public class OrderListController {

	@Autowired
	private OrderListService orderListservice;
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("orderList")
	public ModelAndView findOrderList(
			HttpSession session
			){
		long storeId = (long) session.getAttribute("loginStoreId");
		ModelAndView mav = new ModelAndView();
		CoffeeType coffeeType = new CoffeeType(); 
		List<OrderList> orderLists = this.orderListservice.findOrderLists(storeId);
	
		mav.addObject("orderLists", orderLists);
		mav.addObject("coffeeType", coffeeType);
		mav.setViewName("/order/orderList");
		
		return mav;
	}
	
	
	@RequestMapping(value = "addOrder", method=RequestMethod.GET)
	public ModelAndView	orderForm(
			HttpSession session
			){
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		List<OrderList> orderList = this.orderListservice.findNonePayOrderLists(storeId);
		List<Coffee> coffee = this.coffeeService.findCoffeeList();
		
		List<Code> whipping = this.orderListservice.findCodeByOption("WHIPPING");
		List<Code> syrup = this.orderListservice.findCodeByOption("SYRUP");
		List<Code> shot = this.orderListservice.findCodeByOption("SHOT");
		List<Code> temperature = this.orderListservice.findCodeByOption("TEMPERATURE");
		List<Code> cup = this.orderListservice.findCodeByOption("CUP");
		List<Code> size = this.orderListservice.findCodeByOption("SIZE");

		mav.setViewName("/order/order");
		if(orderList != null){
			mav.addObject("orderList", orderList);
		}else {
			mav.addObject("orderList", "false");
		}
		mav.addObject("coffee", coffee);
		mav.addObject("whipping", whipping);
		mav.addObject("syrup", syrup);
		mav.addObject("shot", shot);
		mav.addObject("cup",cup);
		mav.addObject("size",size);
		mav.addObject("temperature", temperature);
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "addOrder", method=RequestMethod.POST)
	public ModelAndView	order(
			@RequestParam("coffeeName")long coffeeId,
			@RequestParam("whippingOption")String whippingCode,
			@RequestParam("shotOption")String shotCode,
			@RequestParam("syrupOption")String syrupCode,
			@RequestParam("tempOption")String tempCode,
			@RequestParam("cupOption")String cupCode,
			@RequestParam("sizeOption")String sizeCode,
			HttpSession session
			){
		
		ModelAndView mav = new ModelAndView();
		
		OrderList order = new OrderList();
		
		long storeId = (long) session.getAttribute("loginStoreId");
		Store store = new Store();
		store.setId(storeId);
		order.setStore(store);
		
		order.setReceiveTime(new Date());
		
		
		
		Coffee coffee = new Coffee();
		coffee.setId(coffeeId);
		order.setCoffee(coffee);
		
		Code whipping = new Code();
		whipping.setCode(whippingCode);
		order.setWhipping(whipping);
		
		Code syrup = new Code();
		syrup.setCode(syrupCode);
		order.setSyrup(syrup);
		
		Code shot = new Code();
		shot.setCode(shotCode);
		order.setShot(shot);
		
		Code size = new Code();
		size.setCode(sizeCode);
		order.setSize(size);
		
		Code temp = new Code();
		temp.setCode(tempCode);
		order.setTemperature(temp);
		
		Code cup = new Code();
		cup.setCode(cupCode);
		order.setCup(cup);	
		
		this.orderListservice.registerOrderList(order);
		
		mav.setViewName("redirect:/order/addOrder.do");
		
		return mav;
	}
	
	
	@RequestMapping(value="payCoffeeForm", method=RequestMethod.POST)
	public ModelAndView payCoffeeForm(
			HttpSession session
			){
		
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		Long price = this.orderListservice.findPrice(storeId);
		
		if(price != null){
			List<Payment> payment = this.orderListservice.findPayment();
			mav.setViewName("/order/pay_coffee");
			mav.addObject("price", price);
			mav.addObject("payment", payment);
		}
		else {
			mav.setViewName("redirect:/order/addOrder.do");
		}
		return mav;
	}
		
	@RequestMapping(value="payCoffee/searchMember", method=RequestMethod.POST)
	public ModelAndView seachMember(
			@RequestParam("memberNum") String memberNum,
			HttpSession session
			){
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		long price = this.orderListservice.findPrice(storeId);
		List<Payment> payment = this.orderListservice.findPayment();
		mav.setViewName("/order/pay_coffee");

		Member member = this.memberService.findMember(memberNum);
		if(member != null){
			this.orderListservice.setPayMember(member.getId());
			mav.addObject("memberName", member.getName());
			mav.addObject("mileage", member.getMileage());
			mav.addObject("point", member.getPoint());
			mav.addObject("memberNum", member.getPhoneNumber());
			mav.addObject("price", price);
			mav.addObject("payment", payment);
		}else{
			mav.addObject("price", price);
			mav.addObject("payment", payment);
		}
		return mav;
	}
	
	
	@RequestMapping(value="payCoffee",method=RequestMethod.POST)
	public ModelAndView payCoffee(
			@RequestParam("paymentMethod")long payId,
			@RequestParam("price")long price,
			@RequestParam("memberNum")String memberNum
			){
		ModelAndView mav = new ModelAndView();
		
		Member member = this.memberService.findMember(memberNum);
		
		if(payId == 3){//마일리지 사용 (적립 X)
			if(member.getMileage() > price){
				long mileage = (member.getMileage() - price);
				member.setMileage(mileage);
				this.memberService.modifyMileage(member);
			}else{
				List<Payment> payment = this.orderListservice.findPayment();
				mav.addObject("price", price);
				mav.addObject("payment", payment);
				mav.addObject("memberName", member.getName());
				mav.addObject("mileage", member.getMileage());
				mav.addObject("point", member.getPoint());
				mav.addObject("memberNum", member.getPhoneNumber());
				mav.setViewName("/order/pay_coffee");
				return mav;
			}
		} else if(payId == 4){//포인트 사용 (포인트 차감 & 마일리지 적립)
			if(member.getPoint() > price){
				long point = (member.getPoint() - price);
				member.setPoint(point);
				this.memberService.modifyPoint(member);
				long mileage = member.getMileage() + (price/10L);
				member.setMileage(mileage);
				this.memberService.modifyMileage(member);
			} else{
				List<Payment> payment = this.orderListservice.findPayment();
				mav.addObject("price", price);
				mav.addObject("payment", payment);
				mav.addObject("memberName", member.getName());
				mav.addObject("mileage", member.getMileage());
				mav.addObject("point", member.getPoint());
				mav.addObject("memberNum", member.getPhoneNumber());
				mav.setViewName("/order/pay_coffee");
				return mav;
			}
		} else{ // 그 외 결제수단 (마일리지 적립)
			long mileage = member.getMileage() + (price/10L);
			member.setMileage(mileage);
			this.memberService.modifyMileage(member);
		}
		
		this.orderListservice.setPaymentStatus(payId);
		mav.setViewName("redirect:/order/addOrder.do");
		
		return mav;
		
	}
	
	@RequestMapping("dayProfit")
	public ModelAndView totalDayProfit(
			HttpSession session
			){
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		Long totalProfit = this.orderListservice.findDayTotalProfit(storeId);
		if(totalProfit != null){
			List<Profit> profits = this.orderListservice.findDayProfit(storeId);
			mav.addObject("totalProfit", totalProfit);
			mav.addObject("profits",profits);
			mav.addObject("inputValue", 1);
		}else{
			mav.addObject("totalProfit", 0);
		}
		mav.setViewName("/order/total_profit");
		return mav;
	}
	
	@RequestMapping("monthProfit")
	public ModelAndView totalMonthProfit(
			HttpSession session
			){
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		Long totalProfit = this.orderListservice.findMonthTotalProfit(storeId);
		if(totalProfit != null){
			List<Profit> profits = this.orderListservice.findMonthProfit(storeId);
			mav.addObject("totalProfit", totalProfit);
			mav.addObject("profits",profits);
			mav.addObject("inputValue", 2);
		}else{
			mav.addObject("totalProfit", 0);
		}
		
		mav.setViewName("/order/total_profit");
		return mav;
	}
	
	@RequestMapping("yearProfit")
	public ModelAndView totalYearProfit(
			HttpSession session
			){
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		Long totalProfit = this.orderListservice.findYearTotalProfit(storeId);
		if(totalProfit != null){
			List<Profit> profits = this.orderListservice.findYearProfit(storeId);
			mav.addObject("totalProfit", totalProfit);
			mav.addObject("profits",profits);
			mav.addObject("inputValue", 3);
		}else{
			mav.addObject("totalProfit", 0);
		}
		mav.setViewName("/order/total_profit");
		return mav;
	}
	
	@RequestMapping(value = "recieveCheck", method=RequestMethod.POST)
	public ModelAndView recievCheck(
			@RequestParam("no") String[] idStrList
			){
		
		List<Long> idList = new ArrayList<Long>();
		for(String id : idStrList){
			idList.add(Long.parseLong(id));
		}
		
		Set<String> set = new HashSet<String>();
		
		for(long id:idList){
			String phoneNum = this.orderListservice.findOrderById(id).getMember().getPhoneNumber();
			set.add(phoneNum);
		}
		
		for(String phoneNum:set){
		Member member = this.memberService.findMember(phoneNum);
		Sender sender = new Sender(MemberPushTest.APIKey); // 구글 코드에서 발급받은 서버 키
		Message msg = new Message.Builder()
				.addData("coffeeCount", String.valueOf(this.orderListservice.findCoffeeCount(member.getId())))
				.addData("name", member.getName()).build();

		// 푸시 전송. 파라미터는 푸시 내용, 보낼 단말의 id, 마지막은 잘 모르겠음
		Result result;
		try {
			result = sender.send(msg, member.getDeviceId(), 5);

			// 결과 처리
			if (result.getMessageId() != null) {
				// 푸시 전송 성공
			} else {
				String error = result.getErrorCodeName(); // 에러 내용 받기

				// 에러 처리
				if (Constants.ERROR_INTERNAL_SERVER_ERROR.equals(error)) {
					// 구글 푸시 서버 에러
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		this.orderListservice.receiveCheck(idList);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/order/orderList.do");
		return mav;
	}
	
	@RequestMapping("cancleOrder")
	public ModelAndView cancleOrder(){
		ModelAndView mav = new ModelAndView();
		
		this.orderListservice.removeNonePayOrderList();
		
		mav.setViewName("redirect:/order/addOrder.do");
		return mav;
	}
}
