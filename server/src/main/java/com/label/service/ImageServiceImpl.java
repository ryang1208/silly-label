package com.label.service;

import com.google.common.collect.Lists;
import com.label.dao.image.ImageDatasetRepository;
import com.label.dao.image.ImageResourceRepository;
import com.label.dao.image.ImageTaskRequirementRepository;
import com.label.dao.image.ImageTaskRewardRepository;
import com.label.po.image.ImageDataset;
import com.label.po.image.ImageResource;
import com.label.po.image.ImageTaskRequirement;
import com.label.po.image.ImageTaskReward;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

  @Autowired private ImageDatasetRepository imageDatasetRepository;
  @Autowired private ImageResourceRepository imageResourceRepository;
  @Autowired private ImageTaskRequirementRepository imageTaskRequirementRepository;
  @Autowired private ImageTaskRewardRepository imageTaskRewardRepository;

  @Override
  public void uploadImage(Integer userId, List<String> imageUrls, String description) {
    // 存储数据集
    ImageDataset imageDataset = new ImageDataset();
    imageDataset.setUserId(userId);
    imageDataset.setUploadTime(new Date());
    imageDataset.setUploadCount(imageUrls.size());
    imageDataset.setDescription(description);

    ImageDataset entity = imageDatasetRepository.save(imageDataset);

    // 存储image_resource
    List<ImageResource> imageResources = Lists.newArrayList();

    imageUrls.forEach(
        imageUrl -> {
          ImageResource imageResource = new ImageResource();
          imageResource.setDatasetId(entity.getId());
          imageResource.setUrl(imageUrl);

          imageResources.add(imageResource);
        });

    imageResourceRepository.saveAll(imageResources);
  }

  @Override
  public void createMarkTask(
      Integer userId, Integer datasetId, Integer categoryId, List<String> labels, Boolean reward) {
    ImageTaskRequirement imageTaskRequirement = new ImageTaskRequirement();
    imageTaskRequirement.setUserId(userId);
    imageTaskRequirement.setCategoryId(categoryId);
    imageTaskRequirement.setDatasetId(datasetId);
    imageTaskRequirement.setLabel(labels.toString());
    imageTaskRequirement.setReward(reward);
    imageTaskRequirement.setVerifyStatus(false);

    imageTaskRequirementRepository.save(imageTaskRequirement);
  }

  @Override
  public void receiveMarkTask(Integer userId, Integer requirementId) {
    ImageTaskReward imageTaskReward = new ImageTaskReward();
    imageTaskReward.setUserId(userId);
    imageTaskReward.setRequirementId(requirementId);

    imageTaskRewardRepository.save(imageTaskReward);
  }

  @Override
  public void mark() {
    // todo:进行打标
  }
}
