package com.impactante.spaces.domain.adapter.web.apis.rest;

import com.impactante.spaces.domain.application.usecases.GetAllDomainByAccoutUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Api(tags = "Domain by account id")
@RestController
@RequestMapping(value = "/domains/domainByAccountId", produces = MediaType.APPLICATION_JSON_VALUE)
public class DomainByAccountIdController
{
    private final GetAllDomainByAccoutUseCase getAllDomainByAccoutUseCase;

    public DomainByAccountIdController (GetAllDomainByAccoutUseCase getAllDomainByAccoutUseCase)
    {
        this.getAllDomainByAccoutUseCase = getAllDomainByAccoutUseCase;
    }

    @ApiOperation(value = "Obtem lista de domínios por id da conta")
    @GetMapping("/{accountId}")
    public ResponseEntity<List<DomainResponse>> getDomainByAccountId(
            @PathVariable("accountId") UUID accountId
    ) {
        var domains = getAllDomainByAccoutUseCase
                .getAllDomainByAccountId(accountId).stream()
                .map(DomainResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                             .body(domains);
    }
}
