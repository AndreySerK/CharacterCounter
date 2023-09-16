package CharacterCounter.Model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class CharCountResult {

    @NotNull
    private LinkedHashMap<String, Long> result;
}
