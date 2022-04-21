package com.impactante.spaces.domain.adapter.persistence.entities;

import com.impactante.spaces.domain.application.domain.entity.Site;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "site", schema = "domains")
@Entity
@Data
@EqualsAndHashCode
public class SiteEntity
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "site_id")
    private UUID id;

    @OneToMany(mappedBy = "site")
    private List<DomainEntity> domains;

    public Site toEntity()
    {
        return new Site(id);
    }
}
