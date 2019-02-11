package com.strychak.domain;

import com.strychak.enums.Color;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
	private long id;

	private String text;

	private Color color;

}
