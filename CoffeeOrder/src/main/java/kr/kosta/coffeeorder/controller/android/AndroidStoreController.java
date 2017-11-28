package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.domain.Store;
import kr.kosta.coffeeorder.service.MemberService;
import kr.kosta.coffeeorder.service.StoreService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/store")
public class AndroidStoreController
{
	@Autowired
	private StoreService storeService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "getStores", method = RequestMethod.GET)
	@ResponseBody
	public List<Store> getStores()
	{
		return this.storeService.findStores();
	}

	@RequestMapping(value = "checkTime", method = RequestMethod.POST)
	@ResponseBody
	public boolean canOrder(HttpServletRequest request, HttpServletResponse response)
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
		Date date = new Date();
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

			date.setTime((long) jsonObject.get("date"));

			Object storeObj = (Object) jsonObject.get("store");
			JSONObject jStore = (JSONObject) storeObj;

			Store store = new Store();
			store.setId((long) jStore.get("id"));
			store.setContactNumber((String) jStore.get("contactNumber"));
			store.setStoreGuidance((String) jStore.get("storeGuidance"));
			store.setLocation((String) jStore.get("location"));
			store.setBusinessHours((String) jStore.get("businessHours"));
			store.setName((String) jStore.get("name"));

			if(storeService.canOrder(store.getId(), date)<7)
			//TODO 쭊쭊
			

			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

	@RequestMapping(value = "setPrefStore", method = RequestMethod.POST)
	@ResponseBody
	public boolean modifyPreferenceStore(HttpServletRequest request, HttpServletResponse response)
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

			long storeId = (long) jsonObject.get("storeId");
			long memberId = (long) jsonObject.get("memberId");

			Member member = this.memberService.findMemberById(memberId);
			member.setPreferenceStore(storeId);

			this.memberService.modifyMember(member);

			return true;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
