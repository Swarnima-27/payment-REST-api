import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.basic.paytmapp.*")
@EntityScan(basePackages = "com.basic.paytmapp.*")
@EnableJpaRepositories(basePackages = "com.basic.paytmapp.*")
public class Appliaction {
    public static void main(String args[]) throws Exception
    {
        SpringApplication.run(Appliaction.class,args);
    }
}
