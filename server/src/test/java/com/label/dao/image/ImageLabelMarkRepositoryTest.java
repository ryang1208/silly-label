package com.label.dao.image;

import com.label.TestBase;
import com.label.po.image.ImageLabelMark;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;


public class ImageLabelMarkRepositoryTest extends TestBase {

    @Autowired
    private ImageLabelMarkRepository imageLabelMarkRepository;

    @Test
    public void test(){
        ImageLabelMark imageLabelMark = new ImageLabelMark();

        String test = "{\"1\":\"2\"}";

        imageLabelMark.setLabelContent(test);

        imageLabelMarkRepository.save(imageLabelMark);
    }

}