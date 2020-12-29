package tn.iit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.CategoryDao;
import tn.iit.dto.CategoryDto;
import tn.iit.mapper.CategoryMapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Transactional
@Service
public class CategoryService {

    private final CategoryDao categoryDao;
    
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryDto save(CategoryDto categoryDto) {
         this.categoryDao.saveAndFlush (CategoryMapper.categoryDtoToCategory (categoryDto));
         return categoryDto;
    }
    public void deleteById(Long id){
        this.categoryDao.deleteById (id);
    }
    @Transactional(readOnly = true)
    public CategoryDto findOne(Long id){

        return CategoryMapper.categoryToCategoryDto (this.categoryDao.getOne (id));
    }
    @Transactional(readOnly = true)
    public Collection<CategoryDto> findAll(){
        return CategoryMapper.categoriesToCategoriesDtos (this.categoryDao.findAll ());
    }
}
