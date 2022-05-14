package org.isj.ing.annuarium.webapp.services;

import org.isj.ing.annuarium.webapp.mapper.ActeMapper;
import org.isj.ing.annuarium.webapp.model.dto.ActeDto;
import org.isj.ing.annuarium.webapp.model.entities.Acte;
import org.isj.ing.annuarium.webapp.repository.ActeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActeServiceImpl implements IActe{

    @Autowired
    ActeRepository acteRepository;

    @Autowired
    ActeMapper acteMapper;

    @Override
    public int saveActe(ActeDto acteDto) {
        return acteRepository.findActeByNumero(acteDto.getNumero()).isPresent() ? 0 : acteRepository.save(acteMapper.toEntity(acteDto)).getId().intValue();
    }

    @Override
    public ActeDto searchActeByNumero(String numero) {
        return acteMapper.toDto(acteRepository.findActeByNumero(numero).get());
    }

    @Override
    public List<ActeDto> listActes() {

        return acteRepository.findAll().stream().map(acteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public int deleteActe(String numero) {
        acteRepository.deleteById(acteRepository.findActeByNumero(numero).get().getId());
        return 1;
    }

    @Override
    public List<ActeDto> searchActesByKeywords(String keyword) {
        return acteRepository.findActeByNumeroOrNom(keyword, keyword).get().stream()
                .map(acteMapper::toDto)
                .collect(Collectors.toList());
    }
}
