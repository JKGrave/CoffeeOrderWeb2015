package kr.kosta.coffeeorder.service.impl;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.dao.ArticleDao;
import kr.kosta.coffeeorder.domain.Article;
import kr.kosta.coffeeorder.dto.ArticleSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;
import kr.kosta.coffeeorder.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public void registerArticle(Article article) {
		this.articleDao.insertArticle(article);
	}

	@Override
	public void modifyArticle(Article article) {
		this.articleDao.updateArticle(article);
	}

	@Override
	public void removeArticle(long id) {
		this.articleDao.deleteArticle(id);
	}

	@Override
	public Article findArticle(long id) {
		return this.articleDao.selectArticle(id);
	}

	@Override
	public List<Article> findArticles(long storeId) {
		List<Article> articles = this.articleDao.selectArticles(storeId);
		return articles;
	}

	@Override
	public void removeArticles(List<Long> idList) {
		this.articleDao.deleteArticle(idList);
	}
	@Override
	public void modifyReadCount(long id) {
		this.articleDao.updateReadCount(id);
	}

	@Override
	public PageResult findArticlesBySearchCond(ArticleSearchCond search) {
		return this.articleDao.selectArticleBySearchCond(search);
	}


	@Override
	public int findArticleTotalCount(ArticleSearchCond search) {
		return this.articleDao.selectArticleTotalCount(search);
	}


}
