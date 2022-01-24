package chapter03.SpringDI;

import chapter03.SetterInjection.Oracle;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/*
    독립 실행형 자바 애플리케이션. 스프링의 BeanFactory 를 초기화 하고 oracle 빈을 가져오는 방법
    스프링이 제공하는 두 개의 주요 BeanFactory 구현체 중 하나인 DefaultListableBeanFactory 사용
    XmlBeanDefinitionReader 사용해 XML 파일의 BeanDefinition 정보를 읽는다.
    이외에 PropertiesBeanDefinitionReader 는 xml 대신 프로퍼티를 사용해 빈 구성을 관리할 수 있다.
    (프로퍼티는 작고 간단한 애플리케이션에 이상적이지만 빈이 매우 많아지면 관리가 급격히 어려워질 수 있다.)
 */
public class XmlConfigWithBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource("Spring/xml-bean-factory-config.xml"));
        Oracle oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());
    }
}
