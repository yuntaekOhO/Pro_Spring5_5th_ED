package chapter03.CDL;

/*
    * 2-2)
    * 아래 소스처럼 Container 인터페이스로 의존성을 룩업할 수 있다.
    * performLookup() 메서드에서 컨테이너에서 의존성을 가져온다.
    * 이는 의존성 키가 바뀌거나, 컨테이너 인스턴스가 null이거나, 반환된 의존성이 잘못된 타입이면
    * 에러가 발생할 확률이 늘어남
 */
public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    @Override
    public void performLookup(Container container) {
        this.dependency = (Dependency) container.getDependency("myDependency");
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
