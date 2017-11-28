package kr.kosta.coffeeorder.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.dao.ArticleDao;
import kr.kosta.coffeeorder.dao.impl.mapper.ArticleMapper;
import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.dto.ArticleSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public void insertArticle(Article article) {
		this.articleMapper.insertArticle(article);
	}

	@Override
	public void updateArticle(Article article) {
		this.articleMapper.updateArticle(article);
	}

	@Override
	public void deleteArticle(long id) {
		this.articleMapper.deleteArticle(id);
	}

	@Override
	public Article selectArticle(long id) {
		return this.articleMapper.selectArticle(id);
	}

	@Override
	public List<Article> selectArticles(long storeId) {
		List<Article> articles = articleMapper.selectArticles(storeId);
		return articles;
	}

	@Override
	public void deleteArticle(List<Long> idList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idList", idList);
		this.articleMapper.deleteArticles(map);
	}

	public PageResult selectArticle(ArticleSearchCond search) {
		
		List<Article> list = articleMapper.selectArticlesBySearchCond(search);
		
		PageResult pageResult = new PageResult();		
		pageResult.setSearch(search);
		pageResult.setResults(list);
		
		return pageResult;
	}


	@Override
	public void updateReadCount(long id) {
		this.articleMapper.updateReadCount(id);
	}

	@Override
	public PageResult selectArticleBySearchCond(ArticleSearchCond search) {
		int totalCount = this.articleMapper.selectArticleTotalCount(search);
		List<Article> articles = this.articleMapper.selectArticlesBySearchCond(search);
		
		PageResult pageResult = new PageResult();
		pageResult.setSearch(search);
		pageResult.setResults(articles);
		pageResult.setTotalCount(totalCount);
		return pageResult;
	}


	@Override
	public int selectArticleTotalCount(ArticleSearchCond search) {
		int totalCount = this.articleMapper.selectArticleTotalCount(search);
		return totalCount;
	}

	
	
}
