package com.strychak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strychak.domain.ArticleDto;
import com.strychak.service.ArticleService;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	public ArticleService articleService;

	@PostMapping
	public ResponseEntity<?> addArticle(@RequestBody ArticleDto articleDto) {
		articleService.saveArticle(articleDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
