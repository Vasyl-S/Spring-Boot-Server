package com.strychak.service;

import java.util.List;

import com.strychak.domain.UserDto;
import com.strychak.enums.Color;

public interface UserService {

	void saveUser(UserDto userDto);

	List<UserDto> searchByAge(Integer age);

	List<UserDto> searchByArticleColor(Color color);

	List<UserDto> searchUniqueName();

}
