package com.strychak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strychak.domain.UserDto;
import com.strychak.enums.Color;
import com.strychak.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("age")
	public ResponseEntity<List<UserDto>> searchUserAge(@RequestParam Integer age) {
		List<UserDto> users = userService.searchByAge(age);
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}

	@GetMapping("color")
	public ResponseEntity<List<UserDto>> getArticleColor(@RequestParam Color color) {
		List<UserDto> users = userService.searchByArticleColor(color);
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}

	@GetMapping("unique")
	public ResponseEntity<List<UserDto>> getUniqueName() {
		List<UserDto> users = userService.searchUniqueName();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}

}
