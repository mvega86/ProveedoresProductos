package com.inditex.controllers;

import com.inditex.service.dto.MakerDTO;
import com.inditex.percistence.entities.Maker;
import com.inditex.service.IMakerService;
import com.inditex.service.mapper.MakerDTOToMaker;
import com.inditex.service.mapper.MakerToMakerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maker")
public class MakerController {
    @Autowired
    private IMakerService makerService;
    @Autowired
    private MakerDTOToMaker makerDTOToMaker;
    @Autowired
    private MakerToMakerDTO makerToMakerDTO;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isPresent()){
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = makerToMakerDTO.map(maker);

            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MakerDTO> makerDTOList = makerService.findAll()
                .stream()
                .map(maker -> makerToMakerDTO.map(maker))
                .toList();
        return ResponseEntity.ok(makerDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerdto) throws URISyntaxException {
        if(makerdto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        makerService.save(makerDTOToMaker.map(makerdto));

        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody MakerDTO makerDTO){
        Optional<Maker> optionalMaker = makerService.findById(id);

        if(optionalMaker.isPresent()){
            Maker maker = optionalMaker.get();
            makerDTO.setId(maker.getId());
            makerDTO.setProductList(maker.getProductList());
            makerService.save(makerDTOToMaker.mapExist(makerDTO, maker));
            return ResponseEntity.ok("Registro actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id != null) {
            makerService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.notFound().build();
    }
}
