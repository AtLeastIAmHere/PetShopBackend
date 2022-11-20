package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetshopServiceImplTest extends TestCase {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest(){
        PetshopService petshopService;
        User user = new User();
        user.setUsername("IJ");
        user.setAccount("Ij");
        user.setPassword("123");
        userRepository.save(user);
    }


}