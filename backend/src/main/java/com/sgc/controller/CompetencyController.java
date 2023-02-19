package com.sgc.controller;

import com.sgc.service.CompetencyService;
import com.sgc.service.dto.CompetencyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competency")
@RequiredArgsConstructor
public class CompetencyController {

    private final CompetencyService competencyService;

    @GetMapping
    public Page<CompetencyDTO> findAll(Pageable pageable) {
        return competencyService.findAll(pageable);
    }

    @GetMapping("/{idCompetency}")
    public CompetencyDTO findById(@PathVariable Long idCompetency) {
        return competencyService.findById(idCompetency);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetencyDTO create(@RequestBody CompetencyDTO competencyDTO) {
        return competencyService.create(competencyDTO);
    }

    @PutMapping("/{idCompetency}")
    public CompetencyDTO update(@PathVariable Long idCompetency, @RequestBody CompetencyDTO competencyDTO) {
        return competencyService.update(idCompetency, competencyDTO);
    }

    @DeleteMapping("/{idCompetency}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idCompetency) {
        competencyService.delete(idCompetency);
    }
}
