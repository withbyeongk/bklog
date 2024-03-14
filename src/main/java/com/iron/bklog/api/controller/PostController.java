package com.iron.bklog.api.controller;


import com.iron.bklog.api.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PostController {

	@GetMapping("/posts")
	public String post(@RequestBody PostCreate params) {

		log.info("param={}", params.toString());
		return "Hello World!";
	}

}
