package com.sgc.service;

import com.sgc.model.Competency;
import com.sgc.model.enums.Category;
import com.sgc.repository.CompetencyRepository;
import com.sgc.service.dto.CompetencyDTO;
import com.sgc.service.exception.EntityNotFoundException;
import com.sgc.service.mapper.CompetencyMapper;
import com.sgc.util.MessageUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetencyService {

    private final CompetencyRepository competencyRepository;
    private final CompetencyMapper competencyMapper;

    public Page<CompetencyDTO> findAll(Pageable pageable) {
        return competencyRepository.findAll(pageable).map(competencyMapper::toDto);
    }

    public CompetencyDTO findById(Long idCompetency) {
        Competency competency = competencyRepository.findById(idCompetency).orElseThrow(() -> new EntityNotFoundException(MessageUtil.COMPETENCY_NOT_FOUND));
        return competencyMapper.toDto(competency);
    }

    @Transactional
    public CompetencyDTO create(CompetencyDTO competencyDTO) {
        Competency competency = competencyMapper.toEntity(competencyDTO);
        competency = competencyRepository.save(competency);
        return competencyMapper.toDto(competency);
    }

    @Transactional
    public CompetencyDTO update(Long idCompetency, CompetencyDTO competencyDTO) {
        return competencyRepository.findById(idCompetency).map(competency -> {
            competency.setName(competencyDTO.getName());
            competency.setDescription(competency.getDescription());
            competency.setCategory(Category.toEnum(competencyDTO.getCategory()));
            return competencyMapper.toDto(competencyRepository.save(competency));
        }).orElseThrow(() -> new EntityNotFoundException(MessageUtil.COMPETENCY_NOT_FOUND));
    }

    @Transactional
    public void delete(Long id) {
        competencyRepository.updateStatus(competencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.COMPETENCY_NOT_FOUND)).getId());
    }
}
