package com.crio.starter.entities;


import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document(collection = "memes")
public class Meme {
  @Id
  private String id;
  private String url;
  private String name;
  private String caption;
  private LocalDateTime creationTime;
}
