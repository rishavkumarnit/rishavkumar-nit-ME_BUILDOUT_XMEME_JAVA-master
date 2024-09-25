package com.crio.starter.repository;


import com.crio.starter.entities.Meme;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface MemeRepository extends MongoRepository<Meme, String> {

  @Query(value = "{}", sort = "{'creationTime': -1}") 
  List<Meme> findLatestMemes(Pageable pageable);

  boolean existsByNameAndUrlAndCaption(String name, String url, String caption);
}
