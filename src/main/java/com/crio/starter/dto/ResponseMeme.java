package com.crio.starter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class ResponseMeme {
  private String id;
  private String name;
  private String url;
  private String caption;

}
