package chapter03.SetterInjection;

/*
    이 클래스는 Oracle 인터페이스를 구현했을 뿐만아니라 의존성 주입을 위한 수정자[setEncyclopedia()]도 정의하였다.
    비즈니스 메서드는 [defineMeaningOfLife()]이다.
    스프링은 이와 같은 구졸르 다루는데 훨씬 더 편리하다.
    비즈니스 인터페이스에서 의존성을 정의할 필요가 전혀 없다.
    의존성을 정의하는 인터페이스를 사용할 수 있다는 것이 수정자 주입의 잘 알려진 장점이긴 하지만,
    실제로는 *주입을 위한 수정자가 사용자 인터페이스의 외부에 존재하도록 노력해야 한다.*
    !특정 비즈니스 인터페이스의 모든 구현체들이 어떤 특정한 의존성을 필요로 한다고 완전히 확신할 수 없다면,
    구현클래스 각각이 자신의 의존성을 각자 정의하고 비즈니스 인터페이스에는 비즈니스 메서드만 유지해야 한다.
 */
public class BookwormOracle implements Oracle{
    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.encyclopedia = encyclopedia;
    }
    @Override
    public String defineMeaningOfLife() {
        return "Ecyclopedias are a waste of money - go see the world instead";
    }
}
