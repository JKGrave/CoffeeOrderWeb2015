package kr.kosta.coffeeorder.controller.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.service.ArticleService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("android/article")
public class AndroidArticleController
{
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "getArticles", method = RequestMethod.POST)
	@ResponseBody
	public List<Article> getArticles(HttpServletRequest request, HttpServletResponse response)
	{
		long storeId=0;
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
			
			storeId = (long) jsonObject.get("storeId");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return articleService.findArticles(storeId);
	}
}
