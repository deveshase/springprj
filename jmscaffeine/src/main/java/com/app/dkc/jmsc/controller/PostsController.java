package com.app.dkc.jmsc.controller;

import com.app.dkc.jmsc.model.Comment;
import com.app.dkc.jmsc.model.Post;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/webclient")
@Log4j2
public class PostsController {

    @Autowired
    WebClient createWebClient;

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Post>> getPost(@PathVariable("id") int id){
        log.info("PostsController::getPost for id="+id);

        Mono<Post> postMono = createWebClient.get()
                .uri("/posts/" + id)
                .retrieve()
                .bodyToMono(Post.class);

        return new ResponseEntity(postMono, HttpStatus.OK);

    }


    @GetMapping("/comment/{postid}")
    public ResponseEntity<Mono<Comment>> getComment(@PathVariable("postid") int postId){
        log.info("PostsController::getComment for id="+postId);

        Mono<Comment> commentMono = createWebClient.get()
                .uri("/comments/"+postId)
                .retrieve()
                .bodyToMono(Comment.class);

        return new ResponseEntity<Mono<Comment>>(commentMono, HttpStatus.OK);
    }
}
