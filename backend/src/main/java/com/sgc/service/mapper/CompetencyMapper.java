package com.sgc.service.mapper;

import com.sgc.model.Competency;
import com.sgc.model.enums.Category;
import com.sgc.service.dto.CompetencyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = Category.class)
public interface CompetencyMapper extends EntityMapper<CompetencyDTO, Competency> {

    @Override
    @Mapping(target = "category", expression = "java(Category.toEnum(dto.getCategory()))")
    Competency toEntity(CompetencyDTO dto);

    @Override
    @Mapping(target = "category", expression = "java(Category.toValue(entity.getCategory()))")
    CompetencyDTO toDto(Competency entity);
}
