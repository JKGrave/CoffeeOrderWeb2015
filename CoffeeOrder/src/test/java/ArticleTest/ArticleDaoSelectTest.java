package ArticleTest;

import kr.kosta.coffeeorder.dao.ArticleDao;
import kr.kosta.coffeeorder.domain.Article;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleDaoSelectTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"test-applicationContext.xml");

		ArticleDao dao = ctx.getBean(ArticleDao.class);

		Article article = dao.selectArticle(1L);

		System.out.println("id:" + article.getId() + ", board_id:"
				+ article.getBoardId() + ", title:" + article.getTitle()
				+ ", contents:" + article.getContents() + ", read_count:"
				+ article.getReadCount() + ", create_date:"
				+ article.getCreateDate() + ", writer:" + article.getWriter().getName());
	}

}
