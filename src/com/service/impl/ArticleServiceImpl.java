package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ArticleDAO;
import com.entity.Article;
import com.service.ArticleService;

@Service("articleService") //
public class ArticleServiceImpl implements ArticleService { // ArticleServiceImpl 实现了 ArticleService接口

	@Autowired // 它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
	private ArticleDAO articleDAO; // 实现Spring的AOP依赖注入 自动注入AdminDAO接口

	@Override // 继承接口的新增新闻公告表数据 返回值0(失败),1(成功)
	public int insertArticle(Article article) {
		return this.articleDAO.insertArticle(article);
	}

	@Override // 继承接口的更新新闻公告表数据 返回值0(失败),1(成功)
	public int updateArticle(Article article) {
		return this.articleDAO.updateArticle(article);
	}

	@Override // 继承接口的按主键删除新闻公告表数据 返回值0(失败),1(成功)
	public int deleteArticle(String articleid) {
		return this.articleDAO.deleteArticle(articleid);
	}

	@Override // 继承接口的批量删除新闻公告表数据 返回值0(失败),大于0(成功)
	public int deleteArticleByIds(String[] ids) {
		return this.articleDAO.deleteArticleByIds(ids);
	}

	@Override // 继承接口的查询新闻公告表全部数据
	public List<Article> getAllArticle() {
		return this.articleDAO.getAllArticle();
	}

	@Override // 继承接口的按条件精确查询新闻公告表数据
	public List<Article> getArticleByCond(Article article) {
		return this.articleDAO.getArticleByCond(article);
	}

	@Override // 继承接口的按条件模糊查询新闻公告表数据
	public List<Article> getArticleByLike(Article article) {
		return this.articleDAO.getArticleByLike(article);
	}

	@Override // 继承接口的按主键查询新闻公告表数据 返回Entity实例
	public Article getArticleById(String articleid) {
		return this.articleDAO.getArticleById(articleid);
	}

}

