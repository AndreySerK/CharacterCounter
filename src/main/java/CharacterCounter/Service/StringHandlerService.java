package CharacterCounter.Service;

import CharacterCounter.Model.CharCountResult;
import CharacterCounter.Model.StringToHandle;

public interface StringHandlerService {
    CharCountResult handleObject (StringToHandle string);
}
