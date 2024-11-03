package com.kodiatech.learn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KodiatechLearnGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodiatechLearnGatewayApplication.class, args);
	}



	// au lieu d'utiliser application.yml on peut faire la meme ici
@Bean
		public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
			return builder.routes()
					.route(r -> r.path("/student/**")
							.filters(f->f
									.prefixPath("/api")
									.addRequestHeader("X-Powered-By","DanSON Gateway Service"))


							.uri("http://localhost:8081"))
					.route(r ->  r.path("/webflux/**")
							.filters(f->f
									.prefixPath("/api")
									.addRequestHeader("X-Powered-By","DanSON Gateway Service"))


							.uri("http://localhost:8082"))

					.build();
		}











//https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/request-predicates-factories.html
	//https://www.youtube.com/watch?v=EKoq98KqvrI&ab_channel=DanVega
}
