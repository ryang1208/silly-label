package com.label.dao.image;

import com.label.po.image.ImageResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageResourceRepository extends CrudRepository<ImageResource, Integer> {

}
