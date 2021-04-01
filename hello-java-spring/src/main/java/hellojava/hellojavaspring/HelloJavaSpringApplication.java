package hellojava.hellojavaspring;
//여기 하위에 있는 패키지 들면 스프링 빈으로 됩니다

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloJavaSpringApplication {
	//여기서 시작합니다.
	public static void main(String[] args) {
		SpringApplication.run(HelloJavaSpringApplication.class, args);
	}

}
