package chapter03.ConstructorInjection.xml;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    private String name = "Oh Yuntaek";
    private int age = 27;
    private float height = 1.78f;
    private boolean programmer = true;
    private Long ageInSeconds = 816771798L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
