package chapter03.MethodInjection.LookupMethodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;
/*
    abstractLookupBean 은 getMySinger() 를 호출할 때마다 Singer 의 새 인스턴스를 검색한다.
    그러므로 두 참조(singer1,2)가 다름
    standardLookupBean 의 경우 Singer 의 단일 인스턴스가 수정자 주입을 통해 빈으로 전달되어 저장되며,
    getMySinger() 를 호출할 때 마다 해당 인스턴스가 반환되므로 두 참조가 동일하다.

    * 메서드 룩업을 사용하면 스프링이 CGLIB(Code Generator Library)를 사용해 메서드를 동적으로
    재정의하는 AbstractLookupBean 클래스의 하위 클래스를 생선한다.

 */
public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:Spring/app-context-methodinjection-xml.xml");
        ctx.refresh();

        DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);

        ctx.close();
    }

    private static void displayInfo(String beanName, DemoBean bean) {
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();

        System.out.println("" + beanName + ": Singer 인스턴스는 같은가? " + (singer1 == singer2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for(int x=0; x<100000; x++){
            Singer singer = bean.getMySinger();
            singer.sing();
        }

        stopWatch.stop();

        System.out.println("100000번을 얻어오는 데 걸린 시간: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
