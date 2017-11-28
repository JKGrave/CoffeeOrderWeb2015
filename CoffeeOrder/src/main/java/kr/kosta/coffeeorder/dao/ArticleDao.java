package kr.kosta.coffeeorder.dao;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.dto.ArticleSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;

public interface ArticleDao {
	
	public void insertArticle(Article article);
	
	public void updateArticle(Article article);
	
	public void updateReadCount(long id);
	
	public void deleteArticle(long id);
	
	public void deleteArticle(List<Long> idList);
	
	public Article selectArticle(long id);
	
	public List<Article> selectArticles(long storeId);
	

	public PageResult selectArticleBySearchCond(ArticleSearchCond search);
	
	
	public int selectArticleTotalCount(ArticleSearchCond search);
	
}
