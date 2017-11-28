package kr.kosta.coffeeorder.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.domain.Store;
import kr.kosta.coffeeorder.dto.ArticleSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;
import kr.kosta.coffeeorder.service.AdminService;
import kr.kosta.coffeeorder.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("articles")
	public ModelAndView showArticles(
			@RequestParam(value = "page", required=false )Integer page,
			@RequestParam(value = "category", required=false)Long category,
			ArticleSearchCond search,
			HttpSession session
			) {
		
		ModelAndView mav = new ModelAndView();
		long storeId = (long)session.getAttribute("loginStoreId");
		if(page!=null){
			search.setPage(page);
		}
		search.setStoreId(storeId);
		if(category != null && category != 0){
			search.setBoardId(category);
			mav.addObject("category", category);
		}
		
		PageResult pageResult =  this.articleService.findArticlesBySearchCond(search);
		
		pageResult.getTotalPage();
		
		mav.setViewName("/article/articles");
		
		mav.addObject("pageResult", pageResult);
		
		return mav;
	}

	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView registerArticleForm(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/article/register_form");
		
		return mav;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView registerArticle(
			@RequestParam("category") long boardId,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents,
			HttpSession session
			){
		
		ModelAndView mav = new ModelAndView();
		Store writer = new Store();
		long id = (long) session.getAttribute("loginStoreId");
		writer.setId(id);
		Article article = new Article();
		article.setBoardId(boardId);
		article.setTitle(title);
		article.setContents(contents);
		article.setReadCount(0);
		Date createDate = new Date();
		article.setCreateDate(createDate); 
		article.setWriter(writer);
		articleService.registerArticle(article);
		
		mav.setViewName("redirect:/article/articles.do");
		return mav;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView deleteArticle(
			@RequestParam("page")Integer page,
			@RequestParam(value="category", required=false)Long boardId,
			@RequestParam("no")String[] idStrList){
		
		List<Long> idList = new ArrayList<Long>();
		for(String id : idStrList){
			idList.add(Long.parseLong(id));
		}
		articleService.removeArticles(idList);
			
		ModelAndView mav = new ModelAndView();
		if(boardId == null){
			boardId = 0L;
		}
		mav.setViewName("redirect:/article/articles.do?page="+page+"&category="+boardId);
		
		return mav;
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public ModelAndView modifyArticle(
			@RequestParam("page")Integer page,
			@RequestParam("startCategory")Long startCategory,
			@RequestParam(value="category", required=false)Long boardId,
			@RequestParam("id") long id,
			@RequestParam("title") String title,
			@RequestParam("contents") String contents){
		
		ModelAndView mav = new ModelAndView();
		Article article = articleService.findArticle(id);
		article.setTitle(title);
		article.setContents(contents);
		article.setBoardId(boardId);
		Date createDate = new Date();
		article.setCreateDate(createDate);
		
		articleService.modifyArticle(article);
		mav.setViewName("redirect:/article/articles.do?page="+page+"&category="+startCategory);
		mav.addObject("page", page);
		if(boardId !=null && boardId != 0){
			mav.addObject("category", boardId);
		}else{
			mav.addObject("category", 0);
		}
		return mav;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detailArticle(
			@RequestParam("id") long id,
			@RequestParam("page")long page,
			@RequestParam(value="category",required=false)Long boardId
			){
		ModelAndView mav = new ModelAndView();
		
		this.articleService.modifyReadCount(id);
		Article article = articleService.findArticle(id);
		mav.addObject("article", article);
		mav.setViewName("/article/detail_form");
		mav.addObject("page", page);
		if(boardId !=null && boardId != 0){
			mav.addObject("category", boardId);
		}else{
			mav.addObject("category", 0);
		}
		return mav;
	}
	
	@RequestMapping(value="modifyForm", method=RequestMethod.POST)
	public ModelAndView modifyArticleForm(
			@RequestParam("page")Integer page,
			@RequestParam("startCategory")Long startCategory,
			@RequestParam("id") long id){
		
		ModelAndView mav = new ModelAndView();
		Article article = articleService.findArticle(id);
		long boardId = article.getBoardId();
		mav.addObject("article", article);
		mav.setViewName("/article/modify_form");
		mav.addObject("page", page);
		mav.addObject("category", boardId);
		mav.addObject("startCategory", startCategory);
		return mav;
	}
}
