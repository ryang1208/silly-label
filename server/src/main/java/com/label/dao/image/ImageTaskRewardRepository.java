package com.label.dao.image;

import com.label.po.image.ImageTaskReward;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageTaskRewardRepository extends CrudRepository<ImageTaskReward,Integer> {
}
