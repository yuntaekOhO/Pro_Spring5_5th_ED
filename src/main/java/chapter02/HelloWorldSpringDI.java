package chapter02;

import chapter02.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    HelloWorldDecoupledWithFactory까지 작성하면서 모든 요구사항을 충족했지만 여전히 문제점이 남아있다.
    1)애플리케이션 조각을 이어주면서 컴포넌트 결합도를 낮게 유지하기 위해 컴포넌트 접착코드를 많이 작성하였다.
    2)MessageRenderer 구현체에 직접 MessageProvider 인스턴스를 제공했다.
    = MessageSupportFactory클래스 대신 ApplicationContext 인터페이스로 대체한다.
 */
public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();

    }
}
