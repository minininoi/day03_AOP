package Config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

// 캐시
@Order(1)
@Aspect
public class CachedProxy {
    private Map<Long, Object> cachedData = new HashMap<>();

    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs(); // 매개 변수의 갯수를 알 수 없어 배열로 받는다

        Long num = (Long)args[0];
        if(cachedData.containsKey(num)){ //기존 데이터가 있으면 캐시 데이터 사용
            System.out.printf("[%d] 캐시 사용%n", num);
            return  cachedData.get(num);
        }
        Object result = joinPoint.proceed(); // 다음 프록시가 있으면 수행 , 없으면 종료

        //데이터가 없으면 캐시에 기록
        cachedData.put(num, result);
        System.out.printf("[%d] 캐시 추가%n", num);

        return result;
    }
}
