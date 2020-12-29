package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Category;
@Repository
public interface CategoryDao  extends JpaRepository<Category,Long> {
}
