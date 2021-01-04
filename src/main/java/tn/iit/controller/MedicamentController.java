package tn.iit.controller;

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

    public MedicamentController(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @GetMapping("/{id}")
    public MedicamentDto findOne(@PathVariable("id") long id) {
        return this.medicamentService.findOne (id);
    }

    @GetMapping()
    public Collection<MedicamentDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String pageSort
    ) {
        return this.medicamentService.findAll (PageRequest.of(pageNo,pageSize, Sort.by (pageSort).ascending ()));
    }

    @PostMapping
    public MedicamentDto add(@Valid @RequestBody MedicamentDto medicamentDto) {
        return this.medicamentService.save (medicamentDto);
    }

    @PostMapping("/searches")
    public Collection<MedicamentDto> searches(@Valid @RequestBody List<Long> ids){
        return this.medicamentService.findAllByIds(ids);
    }

    @PutMapping()
    public MedicamentDto update(@Valid @RequestBody MedicamentDto medicamentDto) {
        return this.medicamentService.save (medicamentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.medicamentService.deleteById (id);
    }
}