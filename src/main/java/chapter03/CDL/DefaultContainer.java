package chapter03.CDL;

/*
    * 2-1)
    * 컨테이너 인터페이스의 구현체
 */
public class DefaultContainer implements Container {
    @Override
    public Object getDependency(String key) {
        if("myDependency".equals(key)) {
            return new Dependency();
        }

        throw new RuntimeException("Unknown dependency: " + key);
    }
}
