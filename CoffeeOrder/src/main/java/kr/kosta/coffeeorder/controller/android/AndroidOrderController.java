package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosta.coffeeorder.domain.Code;
import kr.kosta.coffeeorder.domain.Coffee;
//import kr.kosta.coffeeorder.domain.Coupon;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.domain.OrderList;
import kr.kosta.coffeeorder.domain.Payment;
import kr.kosta.coffeeorder.domain.PreferenceCoffee;
import kr.kosta.coffeeorder.domain.Store;
import kr.kosta.coffeeorder.service.MemberService;
import kr.kosta.coffeeorder.service.OrderListService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/order")
public class AndroidOrderController
{

	@Autowired
	private OrderListService orderListService;
	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean action(HttpServletRequest request, HttpServletResponse response)
	{
		List<OrderList> orderList = null;
		Store store = null;
		Payment payment = null;
		
		
		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}

		String data = null;
		try
		{
			InputStream is = request.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte buffer[] = new byte[1024];
			int l;

			while ((l = is.read(buffer)) > 0)
			{
				baos.write(buffer, 0, l);
			}

			data = new String(baos.toByteArray(), "UTF-8");
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONObject jsonObject = (JSONObject) obj;
//			{"orderList":{"cup":{"name":null,"groupCode":"CUP","code":"CUP_PAPER"},"member":{"id":4,"point":0,"preferenceStore":0,"mileage":0,"phoneNumber":null,"discountCard":0,"name":null,"preferenceCoffee":null,"password":null,"coupon":null,"deviceId":null},"payment":{"id":2,"name":null},"store":{"id":1,"contactNumber":"02-970-1234","storeGuidance":"서울여대점입니다.","location":"노월구공릉동","businessHours":"08:00~24:00","name":"서울여대점"},"coffee":{"id":4,"price":2500,"name":"카페모카","productInfo":"모카시럽과 휘핑크림으로 달달한 카페모카 입니다."},"payChk":false,"shot":{"name":null,"groupCode":"SHOT","code":"1"},"temperature":{"name":null,"groupCode":"TEMPERATURE","code":"TEMP_HOT"},"size":{"name":null,"groupCode":"SIZE","code":"1"},"id":0,"whipping":{"name":null,"groupCode":"WHIPPING","code":"2"},"syrup":{"name":null,"groupCode":"SYRUP","code":"1"},"receiveChk":false,"receiveTime":1408606200399}}
//{} [{}] == List<객체형>
			JSONObject jOrderList = (JSONObject) jsonObject.get("orderList");
			JSONObject jCup = (JSONObject) jOrderList.get("cup");
			String cupGroupCode = (String) jCup.get("groupCode");
			String cupCode = (String) jCup.get("code");
			JSONObject jMember = (JSONObject) jOrderList.get("member");
			long memberId = (long) jMember.get("id");
			JSONObject jPayment = (JSONObject) jOrderList.get("payment");
			long paymentId = (long) jPayment.get("id");
			JSONObject jStore = (JSONObject) jOrderList.get("store");
			long storeId = (long) jStore.get("id");
			String storeContactNumber = (String) jStore.get("contactNumber");
			String storeGuidance = (String) jStore.get("storeGuidance");
			String storeLocation = (String) jStore.get("location");
			String storeBusinessHours = (String) jStore.get("businessHours");
			String storeName = (String) jStore.get("name");
			JSONObject jCoffee = (JSONObject) jOrderList.get("coffee");
			long coffeeId = (long) jCoffee.get("id");
			long coffeePrice = (long) jCoffee.get("price");
			String coffeeName = (String) jCoffee.get("name");
			String coffeeProductInfo = (String) jCoffee.get("productInfo");
			JSONObject jShot = (JSONObject) jOrderList.get("shot");
			String shotGroupCode = (String) jShot.get("groupCode");
			String shotCode = (String) jShot.get("code");
			JSONObject jTemperature = (JSONObject) jOrderList.get("temperature");
			String temperatureGroupCode = (String) jTemperature.get("groupCode");
			String temperatureCode = (String) jTemperature.get("code");
			JSONObject jSize = (JSONObject) jOrderList.get("size");
			String sizeGroupCode = (String) jSize.get("groupCode");
			String sizeCode = (String) jSize.get("code");
			JSONObject jWhipping = (JSONObject) jOrderList.get("whipping");
			String whippingGroupCode = (String) jWhipping.get("groupCode");
			String whippingCode = (String) jWhipping.get("code");
			JSONObject jSyrup = (JSONObject) jOrderList.get("syrup");
			String syrupGroupCode = (String) jSyrup.get("groupCode");
			String syrupCode = (String) jSyrup.get("code");

			OrderList order = new OrderList();
			
			Member member = memberService.findMemberById(memberId);
			order.setMember(member);
			
			Store orderStore = new Store();
			orderStore.setId(storeId);
			order.setStore(orderStore);
			
			Payment orderPayment = new Payment();
			orderPayment.setId(paymentId);
			order.setPayment(orderPayment);
			
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
			temp.setCode(temperatureCode);
			order.setTemperature(temp);
			
			Code cup = new Code();
			cup.setCode(cupCode);
			order.setCup(cup);	
			
			order.setPayChk(true);
			
			order.setReceiveChk(false);
			
			order.setReceiveTime(new Date());
			
			this.orderListService.registerOrderList(order);
			
			//TODO 만약 결재 방식이 마일리지거나 포인트일 경우 변수 수정
			if(paymentId == 3){
				int mileage = (int) (member.getMileage() - coffeePrice);
				member.setMileage(mileage);
				this.memberService.modifyMileage(member);
			} else if(paymentId == 4) {
				int point = (int) (member.getPoint() - coffeePrice);
				member.setPoint(point);
				this.memberService.modifyPoint(member);
			} else {
				int mileage = (int) (member.getMileage() + coffeePrice/10);
				member.setMileage(mileage);
				this.memberService.modifyMileage(member);
			}
			
			return true;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}
}
