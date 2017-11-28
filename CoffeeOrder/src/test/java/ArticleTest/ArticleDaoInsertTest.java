package ArticleTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.kosta.coffeeorder.dao.ArticleDao;
import kr.kosta.coffeeorder.domain.Article;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleDaoInsertTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		
		ArticleDao dao = ctx.getBean(ArticleDao.class);
		
		Article article = new Article();
		
		Date createDate = new Date();
		
		article.setBoardId(3L);
		article.setTitle("테스트 중");
		article.setContents("테스트 내용");
		article.setReadCount(0);
		article.setCreateDate(createDate);
		
		
		dao.insertArticle(article);
	}

}
