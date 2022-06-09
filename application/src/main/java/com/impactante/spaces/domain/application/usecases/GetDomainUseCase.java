package com.impactante.spaces.domain.application.usecases;

import com.impactante.spaces.domain.application.boundaries.repositories.DomainRepositoryInterface;
import com.impactante.spaces.domain.application.boundaries.usecases.GetAllDomainUseCaseInterface;
import com.impactante.spaces.domain.application.boundaries.usecases.GetDomainUseCaseInterface;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import org.springframework.stereotype.Component;

@Component
public class GetDomainUseCase implements GetDomainUseCaseInterface
{
    private final DomainRepositoryInterface domainRepository;

    public GetDomainUseCase(DomainRepositoryInterface domainRepository)
    {
        this.domainRepository = domainRepository;
    }

    @Override
    public Domain getDomain(String domainName)
    {
        return domainRepository.getDomain(domainName);
    }
}
