package com.impactante.spaces.domain.adapter.persistence.entities;


import com.impactante.spaces.domain.application.domain.entity.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Table(name = "account")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountEntity implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "account_id")
    private UUID id;

    @OneToMany(mappedBy = "account")
    private List<DomainEntity> domains;

    public Account toEntity()
    {
        return new Account(id);
    }
}
