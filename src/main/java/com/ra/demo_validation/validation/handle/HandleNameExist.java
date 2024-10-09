package com.ra.demo_validation.validation.handle;

import com.ra.demo_validation.model.dao.ICategoryDao;
import com.ra.demo_validation.validation.annotation.NameExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class HandleNameExist implements ConstraintValidator<NameExist,String>
{

    // lấy thằng dao để kiểm tra sự tồn tại của name
    // tiêm dao vào thì phải đánh dấu
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        return !categoryDao.existByCategoryName(s);
    }
}
