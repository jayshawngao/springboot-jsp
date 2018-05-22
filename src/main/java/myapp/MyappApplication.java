package myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
	
	//这条配置不再支持：spring.mvc.view.viewClass=org.springframework.web.servlet.view.JstlView
	//并且使用spring.mvc.prefix spring.mvc.suffix配置不起作用，猜测是spring boot版本较高，可能在旧版本中支持，
	//但由于在新版本中进一步减弱了对jsp的支持，因此不再自动配置ViewResolver对象，导致jsp解析失败
	@Bean
	public ViewResolver getViewResolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/jsp/");
	    resolver.setSuffix(".jsp");
	    resolver.setViewClass(JstlView.class);
	    return resolver;
	}
}
