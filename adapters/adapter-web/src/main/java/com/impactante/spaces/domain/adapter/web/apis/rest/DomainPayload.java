package com.impactante.spaces.domain.adapter.web.apis.rest;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class DomainPayload
{
    @ApiModelProperty(value = "id do domínio", example = "e30146d9-c39c-4a61-be68-6014518757ac", required = true)
    private String domainId;

    @ApiModelProperty(value = "id da conta", example = "e30146d9-c39c-4a61-be68-6610518757ac", required = true)
    private String accountId;

    @ApiModelProperty(value = "nome do domínio", example = "www.spaces.com", required = true)
    private String domainName;

    @ApiModelProperty(value = "data de criação do domínio", example = "00-00-0000", required = true)
    private LocalDateTime domainCreatedAt;

    @ApiModelProperty(value = "id do site", example = "e30146d9-c39c-4a61-be68-661051875ccc", required = true)
    private String siteId;

    @ApiModelProperty(value = "status da configuração", example = "true", required = true)
    private Boolean isConfigured;

    @ApiModelProperty(value = "status do certificado", example = "true", required = true)
    private Boolean hasCertificate;

    public String getDomainId()
    {
        return domainId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getDomainName() {
        return domainName;
    }

    public LocalDateTime getDomainCreatedAt() {
        return domainCreatedAt;
    }

    public String getSiteId() {
        return siteId;
    }

    public Boolean getConfigured() {
        return isConfigured;
    }

    public Boolean getHasCertificate() {
        return hasCertificate;
    }
}
