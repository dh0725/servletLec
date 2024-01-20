package hello.servletLec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan	// 서블릿을 서블릿 컨테이너에 자동 등록한다.
@SpringBootApplication
public class ServletLecApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletLecApplication.class, args);
	}

}
