package chapter03.ConstructorInjection.annotated;

import chapter02.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

/*
    annotation을 이용한 생성자 의존성 주입
    @Autowired로 의존성 주입 @Service가 bean name
    생성자 인수에 @Value로 값을 지정할 수 있지만 값을 바꾸려면 소스코드를 변경해야 함 (외부에 두자)
    그 방법은 xml 에 bean 으로 생성하기. 생성자 인자의 이름과 같은 bean id로 설정하면 스프링이 자동으로 연결해준다.
 */
@Service("constructorConfusion")
public class ConstructorConfusion {
    private String someValue;

    //@Autowired
    public ConstructorConfusion(@Value("90") String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    @Autowired
    public ConstructorConfusion(int someValue) {
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

        //MessageProvider mp = (MessageProvider) ctx.getBean("provider");
        //System.out.println(mp.getMessage());
        ctx.close();
    }
}
