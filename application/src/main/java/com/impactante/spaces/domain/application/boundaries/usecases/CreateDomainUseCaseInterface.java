package com.impactante.spaces.domain.application.boundaries.usecases;

import com.impactante.spaces.domain.application.domain.entity.Account;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import com.impactante.spaces.domain.application.domain.entity.Site;

import java.time.LocalDateTime;

public interface CreateDomainUseCaseInterface
{
    Domain createDomain(
            String name,
            Account account,
            Site site,
            LocalDateTime createdAt,
            Boolean isConfigured,
            Boolean hasCertificate
    );
}
