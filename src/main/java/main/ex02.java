package main;

import Config.AppCtx;
import exam02.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ex02 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(Calculator.class);
        long result = cal.factorial(10);
        System.out.println(result);

        result = cal.factorial(10);
        System.out.println(result);

        result = cal.factorial(10);
        System.out.println(result);

        result = cal.factorial(10);
        System.out.println(result);

        ctx.close();
    }
}
