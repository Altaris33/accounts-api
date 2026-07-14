package com.captain.accounts_api.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Component
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class JpaConfig {
}
