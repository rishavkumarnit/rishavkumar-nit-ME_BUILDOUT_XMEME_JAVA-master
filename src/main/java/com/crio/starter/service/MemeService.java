package com.crio.starter.service;

import com.crio.starter.dto.RequestMeme;
import com.crio.starter.dto.ResponseId;
import com.crio.starter.dto.ResponseMeme;
import com.crio.starter.entities.Meme;
import com.crio.starter.exception.MemeAlreadyExistsException;
import com.crio.starter.exception.MemeNotFoundException;
import com.crio.starter.exception.NullRequestException;
import com.crio.starter.repository.MemeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

  @Autowired
  private MemeRepository memeRepository;

  @Autowired
  private ObjectMapper objectMapper;

  public List<ResponseMeme> getLatest100Memes() {
    List<ResponseMeme> result = new ArrayList<>();
    Pageable pageable = PageRequest.of(0, 100);
    List<Meme> listOfMemes = memeRepository.findLatestMemes(pageable);
    for (Meme eachMeme : listOfMemes) {
      result.add(objectMapper.convertValue(eachMeme, ResponseMeme.class));
    }
    return result;
  }

  public ResponseMeme getMeme(String memeId) {
    Optional<Meme> meme = memeRepository.findById(memeId);
    if (meme.isEmpty()) {
      throw new MemeNotFoundException("Meme not found for the given Id");
    }
    ResponseMeme ans = objectMapper.convertValue(meme.get(), ResponseMeme.class);
    return ans;
  }

  public ResponseId addMeme(RequestMeme requestMeme) {
    if (requestMeme == null || requestMeme.getCaption() == null 
        || requestMeme.getName() == null || requestMeme.getUrl() == null) {
      throw new NullRequestException("Null request");
    }
    if (memeAlreadyExists(requestMeme)) {
      throw new MemeAlreadyExistsException("Meme Already Exists");
    }
    Meme meme = objectMapper.convertValue(requestMeme, Meme.class);
    meme.setCreationTime(LocalDateTime.now());
    Meme saved = memeRepository.save(meme);
    ResponseId result = new ResponseId();
    result.setId(saved.getId());
    return result;
  }

  private boolean memeAlreadyExists(RequestMeme requestMeme) {
    return memeRepository.existsByNameAndUrlAndCaption(
      requestMeme.getName(), 
      requestMeme.getUrl(), 
      requestMeme.getCaption()
    );
  }
}
