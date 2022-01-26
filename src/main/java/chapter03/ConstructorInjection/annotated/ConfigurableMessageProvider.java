package chapter03.ConstructorInjection.annotated;

import chapter02.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message, String message2) {
        this.message = message +"\n"+ message2;

    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
