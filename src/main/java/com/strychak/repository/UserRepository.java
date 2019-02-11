package com.strychak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.strychak.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User AS u WHERE age > ?1")
	List<User> findByAge(Integer age);

	@Query(value = "SELECT u.id, u.name, u.age FROM user AS u INNER JOIN article AS a WHERE u.id = a.user_id AND a.color = ?1", nativeQuery = true)
	List<User> findByArticleColor(String color);

	@Query(value = "SELECT DISTINCT u.id, u.name, u.age FROM user AS u INNER JOIN article AS a WHERE u.id = a.user_id GROUP BY u.name HAVING COUNT(a.id) > 3", nativeQuery = true)
	List<User> getUnique();
}
