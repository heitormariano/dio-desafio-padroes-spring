package dio.padroes.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioDesafioPadroesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioDesafioPadroesSpringApplication.class, args);
	}
}
