package de.wp.mvcw.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import de.wp.mvcw.dao.ArticleDao;
import de.wp.mvcw.model.Article;
import de.wp.mvcw.model.impl.ArticleImpl;

public class ArticleDaoImpl implements ArticleDao<Article, Integer> {
	JdbcTemplate jdbcTemplate;

	public ArticleDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void saveOrUpdate(Article e) {

		if (e.getId() != null) {
			// update
			String sql = "UPDATE articles SET article_nummer=?, article_description=?, article_cost=?, article_price=?";
			jdbcTemplate.update(sql, e.getNumber(), e.getName(), e.getCost(), e.getPrice());
		} else {
			// insert
			String sql = "INSERT INTO articles (article_nummer, article_description, article_cost, article_price)"
					+ " VALUES (?, ?,?,?)";
			jdbcTemplate.update(sql, e.getNumber(), e.getName(), e.getCost(), e.getPrice());
		}
	}

	@Override
	public void delete(Integer articleId) {

		String sql = "DELETE FROM articles WHERE article_id=?";
		jdbcTemplate.update(sql, articleId);
	}

	private static Article fromResult(ResultSet rs) throws SQLException {
		Article article = new ArticleImpl();

		article.setId(rs.getInt("article_id"));
		article.setNumber(rs.getInt("article_nummer"));
		article.setName(rs.getString("article_description"));
		article.setCost(rs.getInt("article_cost"));
		article.setPrice(rs.getInt("article_price"));

		return article;
	}

	@Override
	public Article get(Integer articleId) {

		String sql = "SELECT * FROM articles WHERE article_id=" + articleId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Article>() {

			@Override
			public Article extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return fromResult(rs);
				}
				return null;
			}
		});
	}

	@Override
	public List<Article> list() {
		String sql = "SELECT * FROM articles";

		List<Article> listArticles = jdbcTemplate.query(sql, new RowMapper<Article>() {

			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				return fromResult(rs);
			}
		});
		return listArticles;
	}
}