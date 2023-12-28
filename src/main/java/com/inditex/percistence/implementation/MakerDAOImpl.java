package com.inditex.percistence.implementation;

import com.inditex.entities.Maker;
import com.inditex.percistence.IMakerDAO;
import com.inditex.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerrepo;
    @Override
    public Optional<Maker> findById(Long id) {
        return makerrepo.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerrepo.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerrepo.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerrepo.deleteById(id);
    }
}
