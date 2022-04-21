package com.impactante.spaces.domain.application.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Domain
{
    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private Account account;
    private Site site;
    private Boolean isConfigured;
    private Boolean hasCertificate;

    public Domain(
            UUID id,
            String name,
            LocalDateTime createdAt,
            Account account,
            Site site,
            Boolean isConfigured,
            Boolean hasCertificate
    ) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.account = account;
        this.site = site;
        this.isConfigured = isConfigured;
        this.hasCertificate = hasCertificate;
    }

    public UUID getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public Account getAccount()
    {
        return account;
    }

    public Site getSite()
    {
        return site;
    }

    public Boolean getIsConfigured()
    {
        return isConfigured;
    }

    public Boolean getHasCertificate()
    {
        return hasCertificate;
    }

    public static Domain valueOf(
            String name,
            LocalDateTime createdAt,
            Account account,
            Site site,
            Boolean isConfigured,
            Boolean hasCertificate
    ) {
        return new Domain(
                UUID.randomUUID(),
                name,
                createdAt,
                account,
                site,
                isConfigured,
                hasCertificate
        );
    }
}
