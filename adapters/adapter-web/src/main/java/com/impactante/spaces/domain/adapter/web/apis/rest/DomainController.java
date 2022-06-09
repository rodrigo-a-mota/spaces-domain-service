package com.impactante.spaces.domain.adapter.web.apis.rest;

import com.impactante.spaces.domain.application.boundaries.usecases.GetAllDomainUseCaseInterface;
import com.impactante.spaces.domain.application.usecases.GetAllDomainByAccoutUseCase;
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

@Api(tags = "Domain")
@RequestMapping(value = "/domains", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DomainController
{
    private final GetAllDomainUseCaseInterface getAllDomainUseCase;
    private final GetAllDomainBySiteUseCase getAllDomainBySiteUseCase;
    private final GetAllDomainByAccoutUseCase getAllDomainByAccoutUseCase;

    public DomainController(
            GetAllDomainUseCaseInterface getAllDomainUseCase,
            GetAllDomainBySiteUseCase getAllDomainBySiteUseCase,
            GetAllDomainByAccoutUseCase getAllDomainByAccoutUseCase
    )
    {
        this.getAllDomainUseCase = getAllDomainUseCase;
        this.getAllDomainBySiteUseCase = getAllDomainBySiteUseCase;
        this.getAllDomainByAccoutUseCase = getAllDomainByAccoutUseCase;
    }

    @GetMapping
    @ApiOperation(value = "Obtém lista de domínios")
    public ResponseEntity<List<DomainResponse>> getDomains()
    {
        var domains = getAllDomainUseCase.getAllDomain().stream()
                .map(DomainResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(domains);
    }

    @GetMapping(value = "/by/site/{siteId}")
    @ApiOperation(value = "Obtém um domínio pelo site id")
    public ResponseEntity<List<DomainResponse>> getBySiteId(
            @PathVariable("siteId") String siteId
    ) {
        var domains = getAllDomainBySiteUseCase
                .getAllDomainBySiteId(UUID.fromString(siteId)).stream()
                .map(DomainResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(domains);
    }

    @ApiOperation(value = "Obtém lista de domínios por id da conta")
    @GetMapping("/by/account/{accountId}")
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
