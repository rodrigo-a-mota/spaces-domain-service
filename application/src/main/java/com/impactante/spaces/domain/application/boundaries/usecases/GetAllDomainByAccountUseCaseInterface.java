package com.impactante.spaces.domain.application.boundaries.usecases;

import com.impactante.spaces.domain.application.domain.entity.Domain;

import java.util.List;
import java.util.UUID;

public interface GetAllDomainByAccountUseCaseInterface
{
    List<Domain> getAllDomainByAccountId(UUID id);
}
