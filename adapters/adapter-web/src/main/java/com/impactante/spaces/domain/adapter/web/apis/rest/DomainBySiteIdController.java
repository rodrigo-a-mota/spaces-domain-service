package com.impactante.spaces.domain.adapter.web.apis.rest;

import com.impactante.spaces.domain.application.usecases.GetAllDomainBySiteUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Api(tags = "Domain by site id")
@RestController
@RequestMapping(value = "/domains/domainBySite", produces = MediaType.APPLICATION_JSON_VALUE)
public class DomainBySiteIdController
{
    private final GetAllDomainBySiteUseCase getAllDomainBySiteUseCase;

    public DomainBySiteIdController(GetAllDomainBySiteUseCase getAllDomainBySiteUseCase)
    {
        this.getAllDomainBySiteUseCase = getAllDomainBySiteUseCase;
    }

    @ApiOperation(value = "Obtem lista de domínios por id do site")
    @GetMapping("/{siteId}")
    public ResponseEntity<List<DomainResponse>> getDomainBySiteId(
            @PathVariable("siteId") UUID siteId
    ) {
        var domains = getAllDomainBySiteUseCase
                .getAllDomainBySiteId(siteId).stream()
                .map(DomainResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(domains);
    }
}
