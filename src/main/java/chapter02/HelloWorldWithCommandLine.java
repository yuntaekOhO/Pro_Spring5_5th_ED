package chapter02;

/*
    2가지 요구사항을 충족했지만
    여전히 메시지 획득을 담당하는 컴포넌트가 출력 메시지 렌더링도 담당하고있음
 */
public class HelloWorldWithCommandLine {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println((args[0]));
        } else {
            System.out.println("Hello World!");
        }
    }
}
