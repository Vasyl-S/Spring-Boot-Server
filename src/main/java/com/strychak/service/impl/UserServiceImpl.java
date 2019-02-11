package com.strychak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strychak.domain.UserDto;
import com.strychak.entity.User;
import com.strychak.enums.Color;
import com.strychak.repository.UserRepository;
import com.strychak.service.UserService;
import com.strychak.service.utils.ObjectMapperUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapperUtils mapperUtils;

	@Override
	public void saveUser(UserDto userDto) {
		User user = mapperUtils.map(userDto, User.class);
		userRepository.save(user);
	}

	@Override
	public List<UserDto> searchByAge(Integer age) {
		List<User> users = userRepository.findByAge(age);
		List<UserDto> userDto = mapperUtils.mapAll(users, UserDto.class);
		return userDto;
	}

	@Override
	public List<UserDto> searchByArticleColor(Color color) {
		List<User> users = userRepository.findByArticleColor(color.name());
		List<UserDto> userDtos = mapperUtils.mapAll(users, UserDto.class);
		return userDtos;
	}

	@Override
	public List<UserDto> searchUniqueName() {
		List<User> users = userRepository.getUnique();
		List<UserDto> userDto = mapperUtils.mapAll(users, UserDto.class);
		return userDto;
	}

}
