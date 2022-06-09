package com.impactante.spaces.domain.application.boundaries.repositories;

import com.impactante.spaces.domain.application.domain.entity.Domain;

import java.util.List;
import java.util.UUID;

public interface DomainRepositoryInterface
{
    Domain getDomain(String domainName);
    List<Domain> getAllDomain();
    List<Domain> getAllDomainByAccountId(UUID id);
    List<Domain> getAllDomainBySiteId(UUID id);
}
