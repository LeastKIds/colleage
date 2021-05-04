package j210127.ch09;

@FunctionalInterface    //이걸 람다식으로 쓰겠다
public interface MyCalculator {
    int calculate1(int n1, int n2); //추상 메소드는 오직  하나, 2개는 오류 (람다식으로 사용할 것이기 때문에)
}
