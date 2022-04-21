package com.impactante.spaces.domain.application.usecases;

import com.impactante.spaces.domain.application.boundaries.repositories.DomainRepositoryInterface;
import com.impactante.spaces.domain.application.boundaries.usecases.GetAllDomainUseCaseInterface;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllDomainUseCase implements GetAllDomainUseCaseInterface
{
    private final DomainRepositoryInterface domainRepository;

    public GetAllDomainUseCase(DomainRepositoryInterface domainRepository)
    {
        this.domainRepository = domainRepository;
    }

    @Override
    public List <Domain> getAllDomain()
    {
        return domainRepository.getAllDomain();
    }
}
