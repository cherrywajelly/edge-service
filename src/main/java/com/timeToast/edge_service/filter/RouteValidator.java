package com.timeToast.edge_service.filter;

import com.timeToast.edge_service.global.WhitelistProperties;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.function.Predicate;

@Component
public class RouteValidator {

    private WhitelistProperties whitelistProperties;
    private final PathMatcher pathMatcher = new AntPathMatcher();

    public RouteValidator(final WhitelistProperties whitelistProperties) {
        this.whitelistProperties = whitelistProperties;
    }

    public Predicate<ServerHttpRequest> isSecured =
            request -> whitelistProperties.getPaths()
                    .stream()
                    .noneMatch(uri -> pathMatcher.match(uri, request.getPath().toString()));
}
