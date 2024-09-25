package com.crio.starter.dto;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class RequestMeme {
  private String url;
  private String name;
  private String caption;
}
