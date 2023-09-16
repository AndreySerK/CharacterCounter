package CharacterCounter.Service.Impl;

import CharacterCounter.Model.CharCountResult;
import CharacterCounter.Model.StringToHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StringHandlerServiceTest {
    private StringToHandle stringToHandle;
    private LinkedHashMap<String,Long> expectedMap;
    private CharCountResult expectedResult;

    @InjectMocks
    private StringHandlerServiceImpl charCounterService;

    @BeforeEach
    public void init() {
        stringToHandle = new StringToHandle("ff ffD  DD11*");
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
        expectedMap = null;
        expectedResult = null;
    }

    @Test
    void handleString () {
        CharCountResult result = charCounterService.handleObject(stringToHandle);
        assertEquals(expectedResult,result);
        assertNotNull(result);
    }
}