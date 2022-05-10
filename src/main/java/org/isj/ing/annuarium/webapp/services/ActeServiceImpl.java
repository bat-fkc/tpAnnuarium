package org.isj.ing.annuarium.webapp.services;

import org.isj.ing.annuarium.webapp.model.dto.ActeDto;
import org.isj.ing.annuarium.webapp.repository.ActeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActeServiceImpl implements IActe{

    @Autowired
    ActeRepository acteRepository;

    @Override
    public int saveActe(ActeDto acteDto) {
        return 0;
    }

    @Override
    public ActeDto searchActeByNumero(String numero) {
        return null;
    }

    @Override
    public List<ActeDto> listActes() {
        return null;
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
