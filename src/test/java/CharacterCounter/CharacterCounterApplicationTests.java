package CharacterCounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CharacterCounterApplicationTests {

    private final CharacterCounterApplication app;

    @Autowired
    CharacterCounterApplicationTests(CharacterCounterApplication app) {
        this.app = app;
    }

    @Test
    void contextLoads() {
        assertNotNull(app);
    }

}
