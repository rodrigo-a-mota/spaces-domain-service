package com.impactante.spaces.domain.adapter.persistence.repositories;

import com.impactante.spaces.domain.adapter.persistence.entities.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaDomainRepository extends JpaRepository<DomainEntity, UUID>
{
    DomainEntity findByDomainName(String domainName);
    List<DomainEntity> findByAccountId(UUID accountId);
    List<DomainEntity> findBySiteId(UUID SiteId);
}
