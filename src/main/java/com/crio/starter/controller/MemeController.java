package com.crio.starter.controller;


import com.crio.starter.dto.RequestMeme;
import com.crio.starter.dto.ResponseId;
import com.crio.starter.dto.ResponseMeme;
import com.crio.starter.service.MemeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/memes/")
public class MemeController {

  @Autowired
  private MemeService memeService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<ResponseMeme>> latest100Memes() {
    List<ResponseMeme> result = memeService.getLatest100Memes();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("{memeId}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseMeme getByIdMeme(@PathVariable String memeId) {
    return memeService.getMeme(memeId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseId> addTheMeme(@RequestBody RequestMeme requestmeme) {
    ResponseId response = memeService.addMeme(requestmeme);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
