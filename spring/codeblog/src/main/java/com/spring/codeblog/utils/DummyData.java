package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;

@Component
public class DummyData {
	
	@Autowired
	CodeblogRepository codeblogRepository;
	
	//@PostConstruct
	public void savePosts() {
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Michelli Brito");
		post1.setData(LocalDate.now());
		post1.setTitulo("Docker");
		post1.setTexto("Lorem ipsum luctus tellus nisi vitae curabitur sem augue est curabitur platea, metus nibh elementum auctor hac gravida feugiat dui torquent ultricies felis, et scelerisque platea aenean magna aenean sociosqu quisque hac tortor. tempus a ultrices proin curabitur integer potenti, malesuada elit tempus aliquam tempus duis vehicula, velit dapibus cursus habitant curabitur. posuere fames fermentum etiam mollis ullamcorper quis integer, nisl consequat donec et malesuada quisque commodo aliquet, faucibus orci hac litora dolor donec. etiam viverra eu eget varius mauris iaculis vivamus aenean primis rutrum, tincidunt vulputate nostra vivamus ut adipiscing proin suscipit inceptos, cursus nullam lacinia sem pulvinar consectetur odio conubia dictum. ");
		
		Post post2 = new Post();
		post2.setAutor("Marcos Vinicius");
		post2.setData(LocalDate.now());
		post2.setTitulo("API REST");
		post2.setTexto("Molestie adipiscing habitasse pretium porttitor interdum tempus odio bibendum lectus, etiam aliquam praesent ac ligula donec gravida vulputate. fermentum non litora urna aliquam vehicula hendrerit aliquet, hac id diam sollicitudin elit sit enim cubilia, aliquet auctor ut etiam massa ac. curabitur platea euismod nec aptent eu cubilia elit amet, ultrices cursus justo diam cursus pulvinar nec proin, aliquam posuere conubia malesuada tincidunt per eros. metus rutrum sodales elit dui congue fringilla nibh mollis rutrum commodo tellus non auctor habitant tortor, auctor arcu eu sociosqu etiam inceptos ac ipsum ut diam sociosqu nulla vulputate facilisis.");
		
		postList.add(post1);
		postList.add(post2);
		
		for(Post post: postList) {
			Post postSaved = codeblogRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
}
