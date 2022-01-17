package chapter02.annotated;

import chapter02.decoupled.HelloWorldMessageProvider;
import chapter02.decoupled.MessageProvider;
import chapter02.decoupled.MessageRenderer;
import chapter02.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Annotation을 이용하면 XML 구성파일을 대체할 수 있다.
    @Configuration, @ComponentScan을 붙여 애플리케이션 내의 빈정의를 스스로 찾는 클래스로 지정.
 */
@Configuration
public class HelloWorldConfiguration {

    //<bean id="provider" class="..."/> 와 동일함
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    //<bean id="renderer" class="..."/> 와 동일함
    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
