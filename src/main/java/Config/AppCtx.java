package Config;

import exam02.Calculator;
import exam02.ImplCalculator;
import exam02.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Configuration
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppCtx {
    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
//    @Bean
//    public RecCalculator calculator(){
//        return new RecCalculator();
//    }
//    @Bean
//    public ImplCalculator calculator2(){
//        return new ImplCalculator();
//    }
    @Bean
    public CommonPointcut commonPointcut(){
        return new CommonPointcut();
    }
    @Bean
    public CachedProxy cachedProxy(){
        return new CachedProxy();
    }
    @Bean
    public ProxyCalculator2 proxyCalculator2(){
        return new ProxyCalculator2();
    }
}
