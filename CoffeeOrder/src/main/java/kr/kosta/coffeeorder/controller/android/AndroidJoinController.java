package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.service.MemberService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/join")
public class AndroidJoinController
{
	public static final String PROJECT_ID = "242079816327";
	public static final String GOOGLE_API_KEY = "AIzaSyCBbz3fOBDGe8WaWnuW28on2oKARa0NG-k";

	@Autowired
	private MemberService memberService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean action(HttpServletRequest request,
			HttpServletResponse response)
	{
		String phoneNumber = null;
		String password = null;
		String regId = null;
		String name = null;

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
			name = (String) jsonObject.get("name");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Member member = new Member();
		member.setPhoneNumber(phoneNumber);
		member.setDeviceId(regId);
		member.setName(name);
		member.setPassword(password);

		try
		{
			this.memberService.registerMember(member);
			return true;
		}
		catch (DuplicateKeyException e)
		{
			return false;
		}
	}
}