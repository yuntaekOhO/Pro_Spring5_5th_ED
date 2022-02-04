package chapter03.MethodInjection.LookupMethodInjection;

/*
    getMySinger() 메서드를 사용해 Singer 인스턴스에 대한 참조를 가져옴
    doSomething() 메서드는 Singer 클래스에 의존해 작업을 처리하는 메서드
 */
public interface DemoBean {

    Singer getMySinger();

    void doSomething();

}
