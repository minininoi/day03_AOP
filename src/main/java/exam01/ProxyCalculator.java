package exam01;

import exam02.Calculator;

// 성능 확인을 위한 시간 측정 -> 공통 기능
public class ProxyCalculator implements Calculator {
    private  Calculator calculator;
    public ProxyCalculator(Calculator calculator){ // 다형성으로 ImplCalculator, RecCalculator 둘다 주입받아 대신 수행
        this.calculator = calculator;
    }
    @Override
    public long factorial(long num) {
        long startTime = System.nanoTime();// 시작시간

        long result = calculator.factorial(num); // 핵심기능 -> 대신 수행

        long endTime = System.nanoTime();// 종료 시간

        System.out.printf("걸린시간: %d%n", endTime - startTime);

        return result;
    }
}
