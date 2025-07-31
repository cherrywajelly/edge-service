package com.timeToast.edge_service.global;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "security.whitelist")
@Setter
@Getter
public class WhitelistProperties {
    private List<String> paths;
}