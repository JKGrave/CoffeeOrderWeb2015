package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.dto.ArticleSearchCond;

public interface ArticleMapper {

	void insertArticle(Article article);

	void updateArticle(Article article);
	
	void updateReadCount(long id);
	
	void deleteArticle(long id);
	
	Article selectArticle(long id);

	List<Article> selectArticles(long storeId);

	void deleteArticles(Map<String, Object> idList);

	List<Article> selectArticlesBySearchCond(ArticleSearchCond search);
	
	int selectArticleTotalCount(ArticleSearchCond search);
	
	
}
