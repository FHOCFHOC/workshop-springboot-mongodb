package com.corinto.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corinto.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<User>> findAll() {
		User Boris = new User("1", "Boris Dog", "emaildoboris@email.com");
		User Charles = new User("2", "Charles Dog", "emaildocharles@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(Boris, Charles));
		return ResponseEntity.ok().body(list);
	}

	
}
