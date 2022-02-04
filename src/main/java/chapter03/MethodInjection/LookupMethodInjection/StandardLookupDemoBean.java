package chapter03.MethodInjection.LookupMethodInjection;

/*
    수정자 주입을 이용해 Singer 클래스의 인스턴스를 가져오는 클래스
    doSomething() 메서드가 mySinger 에 저장된 Singer 인스턴스를 사용해서 처리를 완료한다.
 */
public class StandardLookupDemoBean implements DemoBean{

    private Singer mySinger;

    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
