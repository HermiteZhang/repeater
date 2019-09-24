package top.hermite.repeater.pigeon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.hermite.repeater.pigeon.dao")
public class PigeonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigeonApplication.class, args);
    }

}
