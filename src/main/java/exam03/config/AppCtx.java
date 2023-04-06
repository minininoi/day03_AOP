package exam03.config;
//DB설정
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppCtx {
    @Bean
    public DataSource dataSource(){ //127.0.0.1
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl(url);
        ds.setUsername("scott");
        ds.setPassword("tiger");

        //DB연결
        ds.setInitialSize(2);
        ds.setMaxActive(10);//최대 10개
        ds.setTestWhileIdle(true);
        ds.setTimeBetweenEvictionRunsMillis(3000);//3초 마다 유휴 객체 연결확인
        ds.setMinEvictableIdleTimeMillis(60000);//60초 이후 연결객체 다시 생성

        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public TestDao testDao(){
        return  new TestDao();
    }
}
