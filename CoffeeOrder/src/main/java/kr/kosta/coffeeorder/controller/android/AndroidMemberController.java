package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import kr.kosta.coffeeorder.domain.Coupon;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.domain.PreferenceCoffee;
import kr.kosta.coffeeorder.service.MemberService;
import kr.kosta.coffeeorder.service.PreferenceCoffeeService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/member")
public class AndroidMemberController
{
	@Autowired
	private MemberService memberService;
	@Autowired
	private PreferenceCoffeeService prefCoffeeService;
	private Long memberId;

	@RequestMapping(value = "modifyInfo", method = RequestMethod.POST)
	@ResponseBody
	public boolean modifyInfo(HttpServletRequest request, HttpServletResponse response)
	{
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
			System.out.println(data);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONObject jsonObject = (JSONObject) obj;

			String regId = (String) jsonObject.get("regId");
			String password = (String) jsonObject.get("password");
			String name = (String) jsonObject.get("name");
			String phoneNumber = (String) jsonObject.get("phoneNumber");

			Member member = this.memberService.findMember(phoneNumber);
			member.setDeviceId(regId);
			member.setName(name);

			if (!password.equals(""))
			{
				member.setPassword(password);
			}

			this.memberService.modifyMember(member);
			
			return true;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

/*	@RequestMapping(value = "getCoupon", method = RequestMethod.POST)
	@ResponseBody
	public List<Coupon> getCoupon(HttpServletRequest request, HttpServletResponse response)
	{
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

			memberId = (Long) jsonObject.get("memberId");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		List<Coupon> coupons = memberService.findCoupons(memberId);

		return coupons;
	}*/

	@RequestMapping(value = "getPrefCoffee", method = RequestMethod.POST)
	@ResponseBody
	public List<PreferenceCoffee> getPrefCoffees(HttpServletRequest request, HttpServletResponse response)
	{
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

			memberId = (Long) jsonObject.get("memberId");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		List<PreferenceCoffee> coffees = this.prefCoffeeService.findCoffees(memberId);
		return coffees;
	}

	@RequestMapping(value = "getMemberInfo", method = RequestMethod.POST)
	@ResponseBody
	public Member getMemberInfo(HttpServletRequest request, HttpServletResponse response)
	{
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

			memberId = (Long) jsonObject.get("memberId");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Member member = this.memberService.findMemberById(memberId);
		return member;
	}

	@RequestMapping(value = "setPrefCoffee", method = RequestMethod.POST)
	@ResponseBody
	public boolean setPrefCoffee(HttpServletRequest request, HttpServletResponse response)
	{
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
			Object objPrefList = parser.parse(data);
			JSONObject jPrefList = (JSONObject) objPrefList;

			JSONObject jCoffee = (JSONObject) jPrefList.get("coffee");
			long coffeeId = (long) jCoffee.get("id");

			memberId = (Long) jPrefList.get("memberId");

			String cup = (String) jPrefList.get("cup");
			String shot = (String) jPrefList.get("shot");
			String size = (String) jPrefList.get("size");
			String syrup = (String) jPrefList.get("syrup");
			String temperature = (String) jPrefList.get("temperature");
			String whipping = (String) jPrefList.get("whipping");

			PreferenceCoffee prefCoffee = new PreferenceCoffee();

			prefCoffee.setCoffeeId(coffeeId);
			prefCoffee.setMemberId(memberId);
			prefCoffee.setCup(cup);
			prefCoffee.setShot(Integer.parseInt(shot));
			prefCoffee.setSize(Integer.parseInt(size));
			prefCoffee.setSyrup(Integer.parseInt(syrup));
			prefCoffee.setTemperature(temperature);
			prefCoffee.setWhipping(Integer.parseInt(whipping));

			this.prefCoffeeService.registerPrefCoffee(prefCoffee);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@RequestMapping(value = "deletePrefCoffee", method = RequestMethod.POST)
	@ResponseBody
	public boolean deletePrefCoffee(HttpServletRequest request, HttpServletResponse response)
	{
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
			Object objPrefList = parser.parse(data);
			JSONObject jPrefList = (JSONObject) objPrefList;

			long id = (Long) jPrefList.get("id");

			this.prefCoffeeService.removePrefCoffee(id);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
