package chapter02.decoupled;

/*
    MessageRenderer 구현 클래스는 메시지를 가져오는 로직과 분리되어 있으며
    제공되는 MessageProvider에게 메시지를 가져오는 책임을 위임한다.
    그러므로 MessageProvider는 MessageRenderer와 의존성이 있다.
 */
public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
