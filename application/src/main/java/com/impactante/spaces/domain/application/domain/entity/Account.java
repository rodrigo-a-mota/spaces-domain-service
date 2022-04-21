package com.impactante.spaces.domain.application.domain.entity;

import java.util.UUID;

public class Account
{
    private UUID id;

    public Account(UUID id)
    {
        this.id = id;
    }

    public UUID getId()
    {
        return id;
    }
}
