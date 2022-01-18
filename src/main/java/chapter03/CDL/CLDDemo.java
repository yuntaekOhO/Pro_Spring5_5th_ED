package chapter03.CDL;

public class CLDDemo {
    public static void main(String[] args) {
        Container container = new DefaultContainer();

        ManagedComponent managedComponent = new ContextualizedDependencyLookup();
        managedComponent.performLookup(container);

        System.out.println(managedComponent);
    }
}
