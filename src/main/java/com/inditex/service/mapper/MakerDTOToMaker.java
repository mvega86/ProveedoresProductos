package com.inditex.service.mapper;

import com.inditex.percistence.entities.Maker;
import com.inditex.service.dto.MakerDTO;
import org.springframework.stereotype.Component;

@Component
public class MakerDTOToMaker implements IMapper<MakerDTO, Maker>{
    @Override
    public Maker map(MakerDTO in) {
        Maker maker = new Maker();
        maker.setId(in.getId());
        maker.setName(in.getName());
        maker.setProductList(in.getProductList());
        return maker;
    }

    @Override
    public Maker mapExist(MakerDTO in, Maker inExist) {
        inExist.setId(in.getId());
        inExist.setName(in.getName());
        inExist.setProductList(in.getProductList());
        return inExist;
    }
}
