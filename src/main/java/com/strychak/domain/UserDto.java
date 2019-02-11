package com.strychak.domain;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private long id;

	private String name;

	private int age;

	private List<ArticleDto> articles;

}
