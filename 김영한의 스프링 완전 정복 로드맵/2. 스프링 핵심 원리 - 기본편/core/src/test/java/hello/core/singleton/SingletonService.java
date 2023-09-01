package hello.core.singleton;

public class SingletonService {
    // 1. static 영역에 객체를 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // 2. instance를 꺼낼 수 있는 것은 getInstance() 메서드만 가능
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private으로 선언해서 외부에서 new SingletonService() 사용한 객체 생성 불가하게 만듬
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
