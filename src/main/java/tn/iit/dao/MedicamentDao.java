package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Medicament;
@Repository
public interface MedicamentDao extends JpaRepository<Medicament,Long> {
}
