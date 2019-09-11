package com.xian.lessonnine.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  14:20
 * @Version: 0.0.1-SHAPSHOT
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorObject.class)
public @interface FlagValidator {

    // flag的有效值多个使用","隔开
    String values();
    // 提示内容
    String message() default "flag不存在";
    // groups 和 payload 这两个parameter 必须包含
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
