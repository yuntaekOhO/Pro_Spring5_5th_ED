package chapter03.ConstructorInjection.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
/*
    단순 값 주입 (Annotation)
 */
@Service("injectSimple")
public class InjectSimple {
    @Value("Oh Yunteak")
    private String name;
    @Value("27")
    private int age;
    @Value("1.78")
    private float height;
    @Value("true")
    private boolean programmer;
    @Value("816771798")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context-annotation.xml");
        ctx.refresh();

        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
        System.out.println(simple);

        ctx.close();
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n"
                + "나이: " + age + "\n"
                + "나이(초): " + ageInSeconds + "\n"
                + "키: " + height + "\n"
                + "프로그래머입니까?: " + programmer;
    }
}
