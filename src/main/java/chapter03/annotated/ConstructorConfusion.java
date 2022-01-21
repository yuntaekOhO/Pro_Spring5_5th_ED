package chapter03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/*
    annotation을 이용한 생성자 의존성 주입
    @Autowired로 의존성 주입 @Service가 bean name
 */
@Service("constructorConfusion")
public class ConstructorConfusion {
    private String someValue;

    @Autowired
    public ConstructorConfusion(@Value("ninety") String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }


    public ConstructorConfusion(@Value("90") int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    @Override
    public String toString() {
        return someValue;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context-annotation.xml");
        ctx.refresh();

        ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
        System.out.println(cc);
        ctx.close();
    }
}
