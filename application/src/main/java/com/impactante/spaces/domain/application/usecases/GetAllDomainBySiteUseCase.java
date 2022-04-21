package com.impactante.spaces.domain.application.usecases;

import com.impactante.spaces.domain.application.boundaries.repositories.DomainRepositoryInterface;
import com.impactante.spaces.domain.application.boundaries.usecases.GetAllDomainBySiteUseCaseInterface;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetAllDomainBySiteUseCase implements GetAllDomainBySiteUseCaseInterface
{
    private final DomainRepositoryInterface domainRepository;

    public GetAllDomainBySiteUseCase(DomainRepositoryInterface domainRepository)
    {
        this.domainRepository = domainRepository;
    }

    @Override
    public List<Domain> getAllDomainBySiteId(UUID siteId)
    {
        return domainRepository.getAllDomainBySiteId(siteId);
    }
}
