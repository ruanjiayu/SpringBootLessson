package com.xian.lessonnine.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  14:26
 * @Version: 0.0.1-SHAPSHOT
 */
public class FlagValidatorObject implements ConstraintValidator<FlagValidator, Object> {

    /**
     * 临时变量保存flag值列表
     */
    private String values;

    /**
     * 初始化value值
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    /**
     * 实现验证
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 分割定义的有效值
        String[] valueArr = values.split(",");
        boolean isFlag = false;
        for (int i = 0; i < valueArr.length; ++i) {
            if (valueArr[i].equals(value)){
                isFlag = true;
                break;
            }
        }
        return isFlag;
    }
}
