package exam01;

import exam02.Calculator;
import exam02.ImplCalculator;
import exam02.RecCalculator;

public class ex02 {
    public static void main(String[] args){
        ProxyCalculator cal1 = new ProxyCalculator(new ImplCalculator());
        ProxyCalculator cal2 = new ProxyCalculator(new RecCalculator());

         printResult(cal1);
         printResult(cal2);
    }
    public static void printResult (Calculator cal){
        long result = cal.factorial(10);
        System.out.printf("cal=%d%n", result);
    }
}
