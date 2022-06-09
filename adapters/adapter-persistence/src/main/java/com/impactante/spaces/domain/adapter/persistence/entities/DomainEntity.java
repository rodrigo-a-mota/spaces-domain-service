package com.impactante.spaces.domain.adapter.persistence.entities;

import com.impactante.spaces.domain.application.domain.entity.Domain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "domains")
@Entity
@EqualsAndHashCode
@Data
public class DomainEntity
{
    @Id
    @Column(name = "domain_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @Column(name = "domain_name")
    private String name;

    @Column(name = "domain_created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private SiteEntity site;

    @Column(name = "is_configured")
    private Boolean isConfigured;

    @Column(name = "has_certificate")
    private Boolean hasCertificate;

    public Domain toEntity()
    {
        return new Domain(
                id,
                name,
                createdAt,
                account.toEntity(),
                site.toEntity(),
                isConfigured,
                hasCertificate
        );
    }
}
