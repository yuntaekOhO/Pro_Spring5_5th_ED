package chapter03.ConstructorInjection;

import chapter03.CDL.Dependency;

/*
    * 생성자 의존성 주입의 일반적인 예시
    * 컴포넌트의 생성자(또는 여러 생성자)를 이용해서 해당 컴포넌트가 필요로하는 의존성을 제공하는 방식.
    * 어떤 컴포넌트가 의존성을 인수로 가져오도록 생성자 또는 여러 생성자를 선언한다면
    * IoC 컨테이너는 해당 컴포넌트를 초기화할 때 컴포넌트에 필요한 의존성을 전달한다.
    * !생성자 주입을 사용할 때 의존성 주입 없이는 빈을 생성할 수 없으므로 반드시 의존성을 주입해야 한다.
 */
public class ConstructorInjection {
    private Dependency dependency;

    public ConstructorInjection(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
