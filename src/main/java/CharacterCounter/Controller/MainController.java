package CharacterCounter.Controller;

import CharacterCounter.Model.CharCountResult;
import CharacterCounter.Model.StringToHandle;
import CharacterCounter.Service.Impl.StringHandlerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final StringHandlerServiceImpl service;

    @PostMapping("/api/handler/string")
    public CharCountResult handleString (@RequestBody @Valid StringToHandle obj) {
        return service.handleObject(obj);
    }
}
