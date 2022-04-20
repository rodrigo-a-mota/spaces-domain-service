package com.impactante.spaces.domain.adapter.web.apis.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.impactante.spaces.domain.application.domain.entity.Domain;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DomainResponse
{
    @ApiModelProperty(value = "ID do domínio")
    private UUID id;

    @ApiModelProperty(value = "ID da conta")
    private UUID accountId;

    @ApiModelProperty(value = "Nome do domínio")
    private String name;

    @ApiModelProperty(value = "Data de criação do domínio")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "ID do site relacionado ao domínio")
    private UUID siteId;

    @ApiModelProperty(value = "Status de configuração do domínio")
    private Boolean IsConfigured;

    @ApiModelProperty(value = "Status de certificação do domínio")
    private Boolean hasCertificate;

    public static DomainResponse from(Domain domain)
    {
        return new DomainResponse(
                domain.getId(),
                domain.getAccount().getId(),
                domain.getName(),
                domain.getCreatedAt(),
                domain.getSite().getId(),
                domain.getIsConfigured(),
                domain.getHasCertificate()
        );
    }
}
