package com.itaem.crazy.petshopdemo.modules.petshop.service.impl;

import com.itaem.crazy.petshopdemo.modules.petshop.dao.OperatorRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.SupplierRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.dao.UserRepository;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Operator;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.Supplier;
import com.itaem.crazy.petshopdemo.modules.petshop.entity.User;
import com.itaem.crazy.petshopdemo.modules.petshop.service.PetshopService;
import org.springframework.stereotype.Service;


@Service
public class PetshopServiceImpl implements PetshopService {
    private final UserRepository userRepository;
    private final OperatorRepository operatorRepository;
    private final SupplierRepository supplierRepository;

    public PetshopServiceImpl(UserRepository userRepository, OperatorRepository operatorRepository, SupplierRepository supplierRepository) {
        this.userRepository = userRepository;
        this.operatorRepository = operatorRepository;
        this.supplierRepository = supplierRepository;
    }

    /**
     * 根据userAccount查找user
     *
     * @param account
     * @return User
     */
    @Override
    public User findByUserAccount(String account) {
        User user = userRepository.findByUsername(account);
        return user;
    }

    /**
     * 根据operatorAccount查找operator
     *
     * @param account
     * @return Operator
     */
    @Override
    public Operator findByOperatorAccount(String account) {
        Operator operator = operatorRepository.findByAccount(account);
        return operator;
    }

    /**
     * 根据supplierAccount查找applier
     *
     * @param account
     * @return Supplier
     */
    @Override
    public Supplier findBySupplierAccount(String account) {
        Supplier supplier = supplierRepository.findByAccount(account);
        return supplier;
    }

    // 添加新用户
    @Override
    public void addUser(User user){
        userRepository.save(user);
    }

}
