package com.inditex.percistence;

import com.inditex.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    Optional<Maker> findById(Long id);

    List<Maker> findAll();

    void save(Maker maker);

    void deleteById(Long id);

}