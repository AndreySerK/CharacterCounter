package CharacterCounter.Controller;

import CharacterCounter.Model.CharCountResult;
import CharacterCounter.Model.StringToHandle;
import CharacterCounter.Service.Impl.StringHandlerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    private StringToHandle stringToHandle;
    private StringToHandle wrongStringToHandle;
    private CharCountResult expectedResult;
    private LinkedHashMap<String,Long> expectedMap;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private StringHandlerServiceImpl service;

    @BeforeEach
    public void init() {
        stringToHandle = new StringToHandle("ff ffD  DD11*");
        wrongStringToHandle = new StringToHandle("");
        expectedMap = new LinkedHashMap<>();
        expectedMap.put("f",4L);
        expectedMap.put("D",3L);
        expectedMap.put("1",2L);
        expectedMap.put("*",1L);
        expectedResult = new CharCountResult(expectedMap);
    }
    @AfterEach
    public void getNull() {
        stringToHandle = null;
        wrongStringToHandle = null;
        expectedResult = null;
    }

    @Test
    public void handleStringWithMoreThenOneChar_thenResponseStatusOk() throws Exception {

      mockMvc.perform(post ("/api/handler/string", stringToHandle)
                      .content(mapper.writeValueAsString(stringToHandle))
                      .contentType(MediaType.APPLICATION_JSON))
                      .andDo(print())
                      .andExpect(status().isOk())
                      .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }

    @Test
    public void handleStringWithLessThenTwoChars_thenResponseStatusBadRequest() throws Exception {

      mockMvc.perform(post ("/api/handler/string", wrongStringToHandle)
                      .content(mapper.writeValueAsString(wrongStringToHandle))
                      .contentType(MediaType.APPLICATION_JSON))
                      .andExpect(status().isBadRequest())
                      .andExpect(mvcResult -> mvcResult
                              .getResolvedException()
                              .getMessage()
                              .contains("String must be at least 2 characters long!"));
    }
}