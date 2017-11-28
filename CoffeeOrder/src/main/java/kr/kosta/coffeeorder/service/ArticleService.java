package kr.kosta.coffeeorder.service;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.dto.ArticleSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;

public interface ArticleService {
	
	public void registerArticle(Article article);
	public void modifyArticle(Article article);
	public void modifyReadCount(long id);
	public void removeArticle(long id);
	public void removeArticles(List<Long> idList);
	public Article findArticle(long id);
	public List<Article> findArticles(long storeId); 
	public PageResult findArticlesBySearchCond(ArticleSearchCond search);
	public int findArticleTotalCount(ArticleSearchCond search);
}
