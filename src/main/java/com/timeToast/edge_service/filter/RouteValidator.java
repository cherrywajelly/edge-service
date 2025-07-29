package com.timeToast.edge_service.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/api/v1/login/**",
            "/api/v1/members/refreshToken",
            "/h2-console/**",
            "/actuator/**",
            "/api/swagger-ui/** ",
            "/docs/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/api-docs/**"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
