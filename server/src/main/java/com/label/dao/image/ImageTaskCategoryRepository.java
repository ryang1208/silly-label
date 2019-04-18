package com.label.dao.image;

import com.label.po.image.ImageTaskCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageTaskCategoryRepository extends CrudRepository<ImageTaskCategory, Integer> {

}
