package exam01;

import exam02.ImplCalculator;
import exam02.RecCalculator;

public class ex01 {
    public static void main(String[] args){

        long startTime = System.nanoTime();
        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(10);
        System.out.printf("cal1=%d%n",result1);
        long endTime = System.nanoTime();
        System.out.printf("걸린시간: %d%n", endTime-startTime);

        startTime = System.nanoTime();
        RecCalculator cal2 = new RecCalculator(); // 재귀적 방식이 느림
        long result2 = cal2.factorial(10);
        System.out.printf("cal2=%d%n",result2);
        endTime = System.nanoTime();
        System.out.printf("걸린시간: %d%n", endTime - startTime);
    }
}
