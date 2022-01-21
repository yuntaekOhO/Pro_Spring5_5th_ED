package chapter03.ConstructorInjection;

import chapter02.decoupled.MessageProvider;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context.xml");
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean("provider", MessageProvider.class);

        System.out.println(messageProvider.getMessage());
        ctx.close();

    }
}
