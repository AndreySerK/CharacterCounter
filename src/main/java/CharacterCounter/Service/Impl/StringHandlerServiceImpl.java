package CharacterCounter.Service.Impl;

import CharacterCounter.Model.CharCountResult;
import CharacterCounter.Model.StringToHandle;
import CharacterCounter.Service.StringHandlerService;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringHandlerServiceImpl implements StringHandlerService {

    @Override
    public CharCountResult handleObject(StringToHandle obj) {

        LinkedHashMap<String,Long> map = obj.getString().codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(s->!s.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return new CharCountResult(map);
    }
}
