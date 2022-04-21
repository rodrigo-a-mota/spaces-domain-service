package com.impactante.spaces.domain.application.usecases;

import com.impactante.spaces.domain.application.boundaries.repositories.DomainRepositoryInterface;
import com.impactante.spaces.domain.application.boundaries.usecases.GetAllDomainByAccountUseCaseInterface;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetAllDomainByAccoutUseCase implements GetAllDomainByAccountUseCaseInterface
{
    private final DomainRepositoryInterface domainRepository;

    public GetAllDomainByAccoutUseCase(DomainRepositoryInterface domainRepository)
    {
        this.domainRepository = domainRepository;
    }

    @Override
    public List<Domain> getAllDomainByAccountId(UUID id)
    {
        return domainRepository.getAllDomainByAccountId(id);
    }
}
