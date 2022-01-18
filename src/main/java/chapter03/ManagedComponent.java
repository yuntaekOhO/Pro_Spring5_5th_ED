package chapter03;

/*
    * 1)
    * CDL (Contextualized Dependency Lookup, 문맥에 따른 의존성 룩업)
    * CDL은 다음 코드와 유사한 인터페이스를 구현하는 컴포넌트를 기반으로 동작한다.
    * 컴포넌트는 이 인터페이스를 구현해 의존 관계를 얻으려는 컨테이너에 신호를 보낸다.
    * 일반적으로 컨테이너는 Tomcat, Jboss같은 기반 애플리케이션 서버나 기반 프레임워크,
    * 스프링과 같은 애플리케이션 프레임워크에서 제공한다.
    * 컨테이너가 컴포넌트에 의존성을 전달할 준비가 되면 컨테이너는 차례대로 performLookup() 메서드를 호출한다.
 */
public interface ManagedComponent {
    void performLookup(Container container);
}
