package top.hermite.repeater.pigeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@tk.mybatis.spring.annotation.MapperScan(basePackages = "top.hermite.repeater.pigeon.*.mapper")
public class PigeonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigeonApplication.class, args);
    }

}
