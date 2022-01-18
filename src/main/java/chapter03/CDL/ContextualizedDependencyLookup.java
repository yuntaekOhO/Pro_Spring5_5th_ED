package chapter03.CDL;

/*
    * 2-2)
    * 아래 소스처럼 Container 인터페이스로 의존성을 룩업할 수 있다.

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
