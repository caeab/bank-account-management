package com.caetano.bankaccountmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.caetano.bankaccountmanagement"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Bank Account CRUD API REST")
				.description("Web API Restfull para gerenciamento de contas e pagamentos").version("1.0.0")
				.license("MIT License").licenseUrl("https://github.com/caeab/bank-account-management/blob/main/LICENSE")
				.contact(new Contact("Caetano Alcantara Borges", "linkedin.com/in/caetano-alcantara-borges-7ba8b3101",
						"caetanoalcantara@gmail.com"))
				.build();
	}
}
