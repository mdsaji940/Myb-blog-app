package myblogapp.config;

import org.jcp.xml.dsig.internal.dom.DOMKeyInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(getInfo())
              .select().apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo() {

        return new ApiInfo("Blogging application: Backend course", "This project is developed by sajid","1.8", "Terms of service",new Contact("Sajid","https://learnwithsajid","sajid@gmail.com"),"License of APIS", "API License url", Collections.emptyList());
    };
}
