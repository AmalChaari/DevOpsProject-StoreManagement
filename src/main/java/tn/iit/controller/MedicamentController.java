package tn.iit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.MedicamentDto;
import tn.iit.service.MedicamentService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/medicaments")
@RestController()
public class MedicamentController {

    private final MedicamentService medicamentService;
    private final Logger logger = LoggerFactory.getLogger (MedicamentController.class);


    public MedicamentController(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @GetMapping("/{id}")
    public MedicamentDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Get Medicament {}", id);
        return this.medicamentService.findOne (id);
    }

    @GetMapping()
    public Collection<MedicamentDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String pageSort
    ) {
        this.logger.debug ("Get all medicaments");
        return this.medicamentService.findAll (PageRequest.of(pageNo,pageSize, Sort.by (pageSort).ascending ()));
    }

    @PostMapping
    public MedicamentDto add(@Valid @RequestBody MedicamentDto medicamentDto) {
        this.logger.debug ("Add new Medicament {}", medicamentDto);
        return this.medicamentService.save (medicamentDto);
    }

    @PostMapping("/searches")
    public Collection<MedicamentDto> searches(@Valid @RequestBody List<Long> ids){
        this.logger.debug ("Get all medicaments with ids {}",ids);
        return this.medicamentService.findAllByIds(ids);
    }

    @PutMapping()
    public MedicamentDto update(@Valid @RequestBody MedicamentDto medicamentDto) {
        this.logger.debug ("Update Medicament {}", medicamentDto.getId ());
        return this.medicamentService.save (medicamentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.logger.debug ("Delete Medicament {}", id);
        this.medicamentService.deleteById (id);
    }
}