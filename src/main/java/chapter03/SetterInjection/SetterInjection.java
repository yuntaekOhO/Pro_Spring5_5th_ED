package chapter03.SetterInjection;

import chapter03.CDL.Dependency;

/*
    수정자 의존성 주입의 대표적인 예제
 */
public class SetterInjection {
    private Dependency dependency;

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
