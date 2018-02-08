package de.wp.mvcw.dao;

import java.io.Serializable;
import java.util.List;

import de.wp.mvcw.model.Article;

public interface ArticleDao<E extends Object, I extends Serializable> {

	public static final Integer DEFAULT_SIZE = 10;
	public static final Integer DEFAULT_OFFSET = 0;

	void saveOrUpdate(E e);
	
	void delete(Integer id);

	Article get(Integer id);

	List<E> list();
}
