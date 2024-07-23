package dio.padroes_projeto_spring_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PadroesProjetoSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoSpring2Application.class, args);
	}

}
