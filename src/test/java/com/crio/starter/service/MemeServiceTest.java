package com.crio.starter.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.util.Optional;
// import com.crio.starter.dto.ResponseMeme;
// import com.crio.starter.entities.Meme;
// import com.crio.starter.repository.MemeRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.mockito.junit.jupiter.MockitoSettings;
// import org.mockito.quality.Strictness;

// @SpringBootTest
// class MemeServiceTest {

//   @Mock
//   private MemeRepository memeRepository;

//   @InjectMocks
//   private MemeService memeService;

//   @Test
//   void checkMeme() {

//     Meme resposememe1 = new Meme();
//     resposememe1.setId("a");
//     resposememe1.setCaption("a");
//     resposememe1.setName("a");
//     resposememe1.setUrl("a");
//     resposememe1.setCreationTime(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT));

//     ObjectMapper objectMapper = new ObjectMapper();
//     Mockito.when(memeRepository.findById("a"))
//            .thenReturn(Optional.of(resposememe1));

//     ResponseMeme responseMemeOutput = memeService.getMeme("a");
//     Meme ans = objectMapper.convertValue(responseMemeOutput, Meme.class);
//     assertEquals(resposememe1, ans);
//     Mockito.verify(memeRepository, Mockito.times(1)).findById("a");
//   }

// }