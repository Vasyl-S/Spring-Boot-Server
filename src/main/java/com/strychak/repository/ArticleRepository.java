package com.strychak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strychak.entity.Article;

public interface ArticleRepository  extends JpaRepository<Article, Long>{
	

}
