package chapter03.CDL;

import chapter02.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    spring Application에서 의존성 풀을 사용하는 일반적인 예제 코드
    * 이런 종류의 IoC는 JNDI 룩업을 사용하는 EJB 2.1 이하의 버전에서만 자주 사용하는게 아닌
      다양한 환경에서 스프링을 사용할 때도 꼭 필요하다.
    레지스트리에서 의존성을 가져온다.
 */
public class DependencyPull {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
