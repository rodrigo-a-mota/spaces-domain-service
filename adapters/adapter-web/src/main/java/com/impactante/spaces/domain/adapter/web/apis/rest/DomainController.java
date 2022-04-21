package com.impactante.spaces.domain.adapter.web.apis.rest;

import com.impactante.spaces.domain.application.boundaries.usecases.GetAllDomainUseCaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Domain")
@RestController
@RequestMapping(value = "/domains", produces = MediaType.APPLICATION_JSON_VALUE)
public class DomainController
{
    private final GetAllDomainUseCaseInterface getAllDomainUseCase;

    public DomainController(GetAllDomainUseCaseInterface getAllDomainUseCase)
    {
        this.getAllDomainUseCase = getAllDomainUseCase;
    }

    @ApiOperation(value = "Obtem lista de dominios")
    @GetMapping
    public ResponseEntity<List<DomainResponse>> getDomains()
    {
        var domains = getAllDomainUseCase.getAllDomain().stream()
                .map(DomainResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(domains);
    }
}
