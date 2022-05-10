package org.isj.ing.annuarium.webapp.services;

import org.isj.ing.annuarium.webapp.mapper.ActeMapper;
import org.isj.ing.annuarium.webapp.model.dto.ActeDto;
import org.isj.ing.annuarium.webapp.model.entities.Acte;
import org.isj.ing.annuarium.webapp.repository.ActeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActeServiceImpl implements IActe{

    @Autowired
    ActeRepository acteRepository;

    @Autowired
    ActeMapper acteMapper;

    @Override
    public int saveActe(ActeDto acteDto) {
        return acteRepository.save(acteMapper.toEntity(acteDto)).getId().intValue();
    }

    @Override
    public ActeDto searchActeByNumero(String numero) {
        return acteMapper.toDto(acteRepository.findActeByNumero(numero).get());
    }

    @Override
    public List<ActeDto> listActes() {
        
        return acteRepository.findAll().stream().map(acte -> acteMapper.toDto(acte))
                .collect(Collectors.toList());
    }

    @Override
    public int deleteActe(String numero) {
        return 0;
    }

    @Override
    public List<ActeDto> searchActesByKeywords(String keyword) {
        return null;
    }
}
