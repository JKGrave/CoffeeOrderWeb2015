package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.service.MemberService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/login")
public class AndroidLoginController
{
	public static final String PROJECT_ID = "242079816327";
	public static final String GOOGLE_API_KEY = "AIzaSyCBbz3fOBDGe8WaWnuW28on2oKARa0NG-k";

	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Member memberLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		session = request.getSession();
		String phoneNumber = null;
		String password = null;
		String regId = null;

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

			phoneNumber = (String) jsonObject.get("phoneNumber");
			password = (String) jsonObject.get("password");
			regId = (String) jsonObject.get("regId");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Member member = memberService.findMember(phoneNumber);
		if (this.memberService.isEqualsPassword(phoneNumber, password))
		{
			member.setDeviceId(regId);
			this.memberService.modifyMember(member);
			session.setAttribute(phoneNumber, phoneNumber);
			return member;
		}
		return null;
	}

	@RequestMapping(value = "session", method = RequestMethod.POST)
	@ResponseBody
	public Member loginSession(HttpServletRequest request, HttpServletResponse response, HttpSession session)
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

			String phoneNumber = (String) jsonObject.get("phoneNumber");

			if (session.getAttribute(phoneNumber) == null)
			{
				System.out.println("정보음슴");
				return null;
			}
			if (!session.getAttribute(phoneNumber).equals(phoneNumber))
			{
				System.out.println("폰번불일치");
				return null;
			}
			Member member = this.memberService.findMember(phoneNumber);
			return member;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
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

			String phoneNumber = (String) jsonObject.get("phoneNumber");

			session.removeAttribute(phoneNumber);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}