package ArticleTest;

import java.util.Date;

import kr.kosta.coffeeorder.dao.ArticleDao;
import kr.kosta.coffeeorder.domain.Article;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleDaoUpdateTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"test-applicationContext.xml");

		ArticleDao dao = ctx.getBean(ArticleDao.class);
		
		Article article = dao.selectArticle(7L);
		
		article.setBoardId(1L);
		article.setTitle("오늘의 추천음료");
		article.setContents("아메~아메~아메~아메~아메~아메리카노~~");
		article.setReadCount(256);
		article.setCreateDate(new Date());
		
		
		dao.updateArticle(article);
	}

}
