package chapter03;

import org.springframework.context.support.GenericXmlApplicationContext;
/*
    ApplicationContext의 계층적 구조
    부모 컨텍스트에 있는 참조 빈을 자식 컨텍스트에 있는 빈처럼 사용할 수 있다.
    child.setParent(parent);  - 자식 컨텍스트의 setParent(부모)로 설정
    만약 부모와 자식 컨텍스트에 같은 id의 빈이 있다면 property 태그를 사용한다.
    p 네임스페이스는 이런 경우 부모 빈의 참조가 안된다.
    p 네임스페이스는 편리한 단축 표현을 제공하지만 부모 빈을 참조하려고 property 태그를 사용하는 것과 같은
    모든 기능을 제공하지는 않는다.
    꼭 필요한 경우를 제외하고는 혼합해서 사용하지 않도록 p나 <propert> 중 하나의 방법만 쓸 것을 지향한다.
 */
public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:Spring/parent-context.xml");
        parent.refresh();

        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:Spring/child-context.xml");
        child.setParent(parent);
        child.refresh();

        Song song1 = (Song) child.getBean("song1");
        Song song2 = (Song) child.getBean("song2");
        Song song3 = (Song) child.getBean("song3");

        System.out.println("parent 컨텍스트로부터: " +  song1.getTitle());
        System.out.println("child 컨텍스트로부터: " +  song2.getTitle());
        System.out.println("parent 컨텍스트로부터: " +  song3.getTitle());

        child.close();
        parent.close();
    }
}
