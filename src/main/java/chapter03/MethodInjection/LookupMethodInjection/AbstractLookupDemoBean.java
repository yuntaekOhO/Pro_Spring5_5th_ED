package chapter03.MethodInjection.LookupMethodInjection;

/*
    getMySinger() 메서드는 abstract 로 선언되는데, 이 메서드는 doSomething() 메서드 내부에서
    Singer 인스턴스를 가져올 때 호출한다. ->
 */
public abstract class AbstractLookupDemoBean implements DemoBean{

    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
