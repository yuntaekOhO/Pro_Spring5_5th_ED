package chapter02.decoupled;

/*
    MessageProvider의 구현체
    언제나 "Hello World!"를 메시지로 반환한다.
 */
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello World!!";
    }
}
