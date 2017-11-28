package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosta.coffeeorder.domain.Coffee;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.domain.PreferenceCoffee;
import kr.kosta.coffeeorder.service.MemberService;
import kr.kosta.coffeeorder.service.impl.CoffeeServiceImpl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/coffee")
public class AndroidCoffeeController
{
	@Autowired
	private CoffeeServiceImpl coffeeService;
	@Autowired
	private MemberService memberService;

	@ResponseBody
	@RequestMapping("getCoffee")
	public List<Coffee> findCoffees()
	{
		return this.coffeeService.findCoffeeList();
	}

	@ResponseBody
	@RequestMapping(value = "getPrefCoffee", method = RequestMethod.POST)
	public List<PreferenceCoffee> getPrefCoffee(HttpServletRequest request, HttpServletResponse response)
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

			long memberId = (long) jsonObject.get("memberId");
			Member member = this.memberService.findMemberById(memberId);

			return member.getPreferenceCoffee();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
