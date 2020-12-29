package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.dao.MedicamentDao;
import tn.iit.entity.Medicament;
import tn.iit.dto.MedicamentDto;
import tn.iit.mapper.MedicamentMapper;

import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class MedicamentService {

    private final MedicamentDao medicamentDao;
    @Autowired
    public MedicamentService(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public MedicamentDto save(MedicamentDto medicamentDto) {
        this.medicamentDao.saveAndFlush (MedicamentMapper.medicamentDtoToMedicament (medicamentDto));
        return medicamentDto;
    }

    public void deleteById(Long id){
        this.medicamentDao.deleteById (id);
    }

    @Transactional(readOnly = true)
    public MedicamentDto findOne(Long id){
        Medicament medicament=this.medicamentDao.findById (id).orElseThrow () ;
        return MedicamentMapper.medicamentToMedicamentDto (medicament);
    }
    @Transactional(
            readOnly=true
    )
    public Collection<MedicamentDto> findAll(Pageable pageable){
        return MedicamentMapper.medicamentsToMedicamentDtos (this.medicamentDao.findAll (pageable).getContent ());
    }
    @Transactional(readOnly = true)
    public Collection<MedicamentDto> findAllByIds(List<Long> ids){
        return MedicamentMapper.medicamentsToMedicamentDtos (this.medicamentDao.findAllById (ids));
    }
}
