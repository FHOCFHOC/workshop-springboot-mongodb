package com.corinto.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.corinto.workshopmongo.domain.Post;
import com.corinto.workshopmongo.domain.User;
import com.corinto.workshopmongo.dto.AuthorDTO;
import com.corinto.workshopmongo.repository.PostRepository;
import com.corinto.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User boris = new User(null, "Boris Dog", "boris@email.com");
		User alex = new User(null, "Alex Green", "alex@email.com");
		User bob = new User(null, "Bob Grey", "bob@email.com");
		
		userRepository.saveAll(Arrays.asList(boris, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("22/10/2018"), "Ta bom", "trem trem trem trem", new AuthorDTO(boris));
		Post post2 = new Post(null, sdf.parse("23/11/2018"), "Ta ruim", "lixo lixo lixo lixo", new AuthorDTO(boris));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		boris.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(boris);
	}

}
