package ArticleTest;

import kr.kosta.coffeeorder.dao.ArticleDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleDaoDeleteTest {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"test-applicationContext.xml");

		ArticleDao dao = ctx.getBean(ArticleDao.class);
		
		dao.deleteArticle(8L);
	}
}
