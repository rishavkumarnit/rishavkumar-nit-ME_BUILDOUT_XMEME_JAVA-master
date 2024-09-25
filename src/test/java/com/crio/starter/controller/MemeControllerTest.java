package com.crio.starter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.crio.starter.dto.ResponseMeme;
import com.crio.starter.service.MemeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;


@AutoConfigureMockMvc
@SpringBootTest
class MemeControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private MemeService memeService;

  @Test
  void get100Memes() throws Exception {

    final List<ResponseMeme> list = new ArrayList<>();
    ResponseMeme resposememe1 = new ResponseMeme();
    resposememe1.setId("a");
    resposememe1.setCaption("a");
    resposememe1.setName("a");
    resposememe1.setUrl("a");
    list.add(resposememe1);

    //given
    Mockito.doReturn(list)
        .when(memeService).getLatest100Memes();

    // when
    URI uri = UriComponentsBuilder
        .fromPath("/memes/")
        .build().toUri();

    MockHttpServletResponse response = mvc.perform(
        get(uri.toString()).accept(APPLICATION_JSON_VALUE)
    ).andReturn().getResponse();

    //then
    String responseStr = response.getContentAsString();
    ObjectMapper mapper = new ObjectMapper();
    List<ResponseMeme> responseDtoList = mapper.readValue(responseStr, mapper.getTypeFactory()
        .constructCollectionType(List.class, ResponseMeme.class));

    assertEquals(list, responseDtoList);
    Mockito.verify(memeService, Mockito.times(1)).getLatest100Memes();
  }
}