package com.app.dkc.wclient.controller;

import com.app.dkc.wclient.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/webclient")
public class PostsController {

    @Autowired
    WebClient createWebClient;

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Post>> getPost(@PathVariable("id") int id){
        System.out.println("Inside PostsController::getPost");

        Mono<Post> postMono = createWebClient.get()
                .uri("/posts/" + id)
                .retrieve()
                .bodyToMono(Post.class);

        return new ResponseEntity(postMono, HttpStatus.OK);

    }

}
