package chapter02.decoupled;

/*
    메시지 출력 부분과 메시지를 가져오는 로직을 각각의 컴포넌트로 분리 (리팩터링)
    + 애플리케이션을 유연하게 만들려면 인터페이스를 사용해 컴포넌트와 론쳐를 연결해야한다.
 */
public interface MessageProvider {
    String getMessage();
}
