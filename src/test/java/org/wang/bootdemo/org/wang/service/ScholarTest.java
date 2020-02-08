package org.wang.bootdemo.org.wang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wang.bootdemo.BootdemoApplication;
import org.wang.bootdemo.model.Chip;
import org.wang.bootdemo.service.impl.ScholarServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootdemoApplication.class)
public class ScholarTest {

    @Autowired
    ScholarServiceImpl scholarService;

    @Autowired
    Chip chip;
    @Test
    public void test(){
        chip.reset();
        while (! chip.isAllEmpty()) {
            System.out.println(scholarService.throwDice());
        }
        scholarService.printScholars();
        scholarService.printMaxScholar();


    }

}
