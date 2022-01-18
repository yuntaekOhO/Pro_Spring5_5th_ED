package chapter03.CDL;

/*
    * 2)
    * 이 코드는 의존성 룩업 서비스를 제공하는 간단한 컨테이너 인터페이스이다.
 */
public interface Container {
    Object getDependency(String key);
}
