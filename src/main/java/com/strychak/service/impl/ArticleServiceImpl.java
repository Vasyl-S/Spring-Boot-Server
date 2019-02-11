package com.strychak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strychak.domain.ArticleDto;
import com.strychak.entity.Article;
import com.strychak.repository.ArticleRepository;
import com.strychak.service.ArticleService;
import com.strychak.service.utils.ObjectMapperUtils;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ObjectMapperUtils mapperUtils;

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public void saveArticle(ArticleDto articleDto) {
		Article article = mapperUtils.map(articleDto, Article.class);
		articleRepository.save(article);
	}

}
