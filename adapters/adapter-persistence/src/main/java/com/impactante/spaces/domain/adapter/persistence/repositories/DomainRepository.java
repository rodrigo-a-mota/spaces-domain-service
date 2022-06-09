package com.impactante.spaces.domain.adapter.persistence.repositories;

import com.impactante.spaces.domain.adapter.persistence.entities.DomainEntity;
import com.impactante.spaces.domain.application.boundaries.repositories.DomainRepositoryInterface;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DomainRepository implements DomainRepositoryInterface
{
    private final JpaDomainRepository repository;

    public  DomainRepository(JpaDomainRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Domain getDomain(String domainName)
    {
        return repository.findByDomainName(domainName).toEntity();
    }

    @Override
    public List<Domain> getAllDomain()
    {
        return repository.findAll().stream()
                .map(DomainEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Domain> getAllDomainByAccountId(UUID id)
    {
        return repository.findByAccountId(id).stream()
                .map(DomainEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Domain> getAllDomainBySiteId(UUID siteId)
    {
        return repository.findBySiteId(siteId).stream()
                .map(DomainEntity::toEntity)
                .collect(Collectors.toList());
    }
}
