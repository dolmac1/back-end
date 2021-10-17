package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

public class StatefulServiceTest {
    @Test
    void  statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        statefulService1.order("userA",10000);
        statefulService1.order("userB",20000);

        int price = statefulService1.getPrice();
        System.out.println(price);//만원이 나와야하는데 2만원이 나옴

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public  StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
