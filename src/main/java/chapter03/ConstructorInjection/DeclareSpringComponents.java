package chapter03.ConstructorInjection;

import chapter02.decoupled.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
    provider는 annotated package에 ConfigurableMessageProvider.java에서
    @Service로 명시, ConfigurableMessageProvider는 MessageProvider의 구현체 ->
    MessageProvider의 getMessage() 사용
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context-annotation.xml");
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean("provider", MessageProvider.class);

        System.out.println(messageProvider.getMessage());

        ctx.close();

    }
}
