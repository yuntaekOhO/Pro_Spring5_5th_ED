package chapter02.decoupled;

/*
    MessageRenderer와 MessageProvider type 변수에
    StandardOutMessageRenderer, HelloWorldMessageProvider 인스턴스를 생성하는 이유는
    StandardOutMessageRenderer, HelloWorldMessageProvider에 실제 로직이 구현돼 있지만
    애플리케이션 로직에서는 인터페이스가 제공하는 메서드만 사용해 상호작용을 해야하기 때문이다.
    이로인해 결합도는 낮아졌지만 문제점 아직 남아있다.
    문제점 : MessageRenderer, MessageProvider 인터페이스 구현체를 변경하려면 코드를 변경해야한다. (MessageSupportFactory.java)
 */
public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
