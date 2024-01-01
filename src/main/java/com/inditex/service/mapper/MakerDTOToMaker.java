package com.inditex.service.mapper;

import com.inditex.percistence.entities.Maker;
import com.inditex.service.dto.MakerDTO;

public class MakerDTOToMaker implements IMapper<MakerDTO, Maker>{
    @Override
    public Maker map(MakerDTO in) {
        Maker maker = new Maker();
        maker.setName(in.getName());
        maker.setProductList(in.getProductList());
        return maker;
    }

    @Override
    public Maker mapExist(MakerDTO in, Maker inExist) {
        inExist.setName(in.getName());
        inExist.setProductList(in.getProductList());
        return inExist;
    }
}
