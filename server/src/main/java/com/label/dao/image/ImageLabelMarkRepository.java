package com.label.dao.image;

import com.label.po.image.ImageLabelMark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageLabelMarkRepository extends CrudRepository<ImageLabelMark,Integer> {


}
