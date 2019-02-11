package com.strychak;

import com.strychak.domain.UserDto;
import com.strychak.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootServerApplicationTests {

	@MockBean
	private UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void searchByAgeTest() throws Exception {
		UserDto user1 = new UserDto();
		user1.setName("Mark");
		user1.setAge(11);
		UserDto user2 = new UserDto();
		user1.setName("Tom");
		user1.setAge(25);
		List<UserDto> testData = new ArrayList<>();
		testData.add(user1);
		testData.add(user2);

		when(userService.searchByAge(anyInt())).thenReturn(testData);

		mockMvc.perform(MockMvcRequestBuilders.get("/user/age").param("age", "10")).andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void searchByAgeEmptyTest() throws Exception {
		when(userService.searchByAge(anyInt())).thenReturn(new ArrayList<>());

		mockMvc.perform(MockMvcRequestBuilders.get("/user/age").param("age", "10")).andExpect(status().isNoContent())
				.andDo(print()).andReturn();
	}
}