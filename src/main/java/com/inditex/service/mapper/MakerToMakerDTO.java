package com.inditex.service.mapper;

import com.inditex.percistence.entities.Maker;
import com.inditex.service.dto.MakerDTO;

public class MakerToMakerDTO implements IMapper<Maker, MakerDTO>{
    @Override
    public MakerDTO map(Maker in) {
        MakerDTO makerDTO = new MakerDTO();
        makerDTO.setName(in.getName());
        makerDTO.setProductList(in.getProductList());
        return makerDTO;
    }

    @Override
    public MakerDTO mapExist(Maker in, MakerDTO inExist) {
        inExist.setName(in.getName());
        inExist.setProductList(in.getProductList());
        return inExist;
    }
}
