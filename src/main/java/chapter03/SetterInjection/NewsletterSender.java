package chapter03.SetterInjection;

/*
    비즈니스 인터페이스에 의존성 주입을 위해 항상 수정자를 정의하지는 않지만(이전까지 보았던),
    *구성 인자(configuration parameter)를 정의하는 수정자와 접근자를 두는 것은 좋은 생각이며
    수정자 주입을 유용하게 사용할 수 있는 방법이기도 하다.
    구성 인자는 의존성의 특수한 형태로 볼 수 있다.
    사용자 컴포넌트는 비즈니스 구성 인자에 의존하며 이런 비즈니스 구성 인자는 지금까지 살펴본 의존성 방식과는 상당히 다르다.

    이메일로 뉴스레터 모음을 전송하는 클래스는 이 인터페이스를 구현한다.
    인터페이스에서 send()가 유일한 비즈니스 메서드지만 그 외에도 자바빈 프로퍼티 두 개가 더 정의되어있다.
    여기서 SMTP 서버 주소와 이메일의 발신 주소가 실제로는 의존성이 아니고
    이 인터페이스의 모든 구현체가 동작하는데 사용되는 상세 구성 정보를 담고있다.

    구성 인자와 구성인자가 아닌 의존성 사이의 차이점 :
    1) 구성 인자는 수동적이다. [SMTP 서버 인자는 수동적인 의존성의 한 예이다.]
        - 수동적인 의존성은 직접적으로 동작을 수행하는데 사용되지 않는다.
        - 수동적인 의존성은 내부에서 사용되거나 필요한 작업을 수행하는 다른 의존성에서 사용된다.
        ch2의 MessageProvider 의존성은 수동적이지 않다.
        MessageRenderer가 자신의 작업을 완료하는데 필요한 기능(메시지 제공)을 수행했기 때문

    2) 구성 인자는 일반적으로 다른 어떤 컴포넌트가 아니라 "정보 자체"이다.
        - 즉, 구성 인자는 컴포넌트가 자신의 작업을 완료하는 데 필요한 정보를 의미한다.
    [SMTP 서버 정보는 분명 NewsletterSender에게 필요한 정보지만,
     MessageProvider는 실제로 MessageRenderer가 제대로 동작하는 데 필요한 또 다른 컴포넌트이다.]

    3) 구성 인자는 대개 단순한 값(simple value)이거나 단순한 값들의 컬렉션이다.
        - 구성 인자가 자바 상에서 원시타입(또는 이를 래핑한 클래스)이거나, 문자열이거나, 이런 타입 값들의 컬렉션이다.
        - 단순한 값들은 일반적으로 수동적이다. 이는 문자열이 나타내는 데이터를 조작하는 것 말고는 다른 작업을 수행할 수 없다는 것을 의미.
        - 대부분 이러한 값들은 정보를 나타내는 용도로 사용한다.

    * 비즈니스 인터페이스 내에서 구성 옵션을 정의할지 말지 고민된다면
      구성 인자가 비즈니스 인터페이스의 모든 구현체에서 사용될지, 단 하나의 구현체에서만 사용될지 고려한다.
 */
public interface NewsletterSender {
    void setSmtpServer(String smtpServer);
    String getStmtpServer();
    void setFromAddress(String fromAddress);
    String getFromAddress();

    void send();
}
