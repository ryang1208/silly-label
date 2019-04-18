package com.label;


import com.label.po.user.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBase {

    @Test
    public void test() {
        System.out.println("hello");
    }
}
