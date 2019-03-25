package com.label.dao.image;

import com.label.po.image.ImageLabelStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageLabelStatusRepository extends CrudRepository<ImageLabelStatus,Integer> {
}
