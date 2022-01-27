package chapter03.ConstructorInjection.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
/*
    SpEL 로 단순 값 주입 app-context-spel.xml 참조
    InjectSimpleConfig.java <- value, getter 지정된 클래스

 */
public class InjectSimpleSpel {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n"
                + "나이: " + age + "\n"
                + "나이(초): " + ageInSeconds + "\n"
                + "키: " + height + "\n"
                + "프로그래머입니까?: " + programmer;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context-spel.xml");
        ctx.refresh();

        InjectSimpleSpel simple = (InjectSimpleSpel) ctx.getBean("injectSimpleSpel");
        System.out.println(simple);
        System.out.println(simple.getClass());

        ctx.close();
    }
}
