package com.captain.accounts_api.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "auditAwareImpl")
public class AuditAwareimpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Hardcoding the auditor to ACCOUNT_MS for now
        // Where MS stands for "MicroService"
        return Optional.of("ACCOUNT_MS");
    }
}
