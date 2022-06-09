package com.impactante.spaces.domain.application.boundaries.usecases;

import com.impactante.spaces.domain.application.domain.entity.Domain;

public interface GetDomainUseCaseInterface
{
    Domain getDomain(String domainName);
}
