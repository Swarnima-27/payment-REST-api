import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.basic.paymentapp.*")
@EntityScan(basePackages = "com.basic.paymentapp.*")
@EnableJpaRepositories(basePackages = "com.basic.paymentapp.*")
@EnableCaching
public class Appliaction {
    public static void main(String args[]) throws Exception
    {
        SpringApplication.run(Appliaction.class,args);
    }
}
