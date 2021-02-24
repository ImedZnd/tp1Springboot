package isi.utm.tn.tpdevav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class TpDevAvApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpDevAvApplication.class, args);
    }

}
