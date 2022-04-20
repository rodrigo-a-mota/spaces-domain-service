package com.impactante.spaces.domain.application.domain.entity;

import java.util.UUID;

public class Site
{
    private UUID id;

    public Site(UUID id)
    {
        this.id = id;
    }

    public UUID getId()
    {
        return id;
    }
}
