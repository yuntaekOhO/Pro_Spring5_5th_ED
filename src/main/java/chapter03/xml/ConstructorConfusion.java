package chapter03.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/*
    인수의 타입(String, int)에 따라 초기화 되는 생성자가 다르다.
    인수는 resources/Spring/app-context-constructor.xml에
    constructor-arg value 태그에서 변경 가능
 */
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusion(int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context-constructor.xml");
        ctx.refresh();
        ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
        System.out.println(cc);
        ctx.close();
    }

    @Override
    public String toString() {
        return someValue;
    }
}
