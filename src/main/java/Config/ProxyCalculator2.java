package Config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
public class ProxyCalculator2 {
    public void publicTarget(){}
    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws  Throwable{  // Object 모든 반환값 포함

        long startTime = System.nanoTime();

        Object result  = joinPoint.proceed(); //factorial 핵심 기능

        long endTime = System.nanoTime();
        System.out.printf("걸린시간 : %d%n", endTime - startTime);

        return result;
    }
}
