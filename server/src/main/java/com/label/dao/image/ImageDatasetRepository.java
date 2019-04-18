package com.label.dao.image;

import com.label.po.image.ImageDataset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDatasetRepository extends CrudRepository<ImageDataset, Integer> {

}
