package com.xian.lessonnine.dto;

import com.xian.lessonnine.validator.FlagValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/11  13:54
 * @Version: 0.0.1-SHAPSHOT
 */
@Data
public class DemoDTO implements Serializable {

    private static final long serialVersionUID = 7271588440403304582L;

    @NotBlank
    @Length(min = 2, max = 10)
    private String name;

    @Min(value = 1)
    private int age;

    @FlagValidator(values = "1,3,5")
    private String flag;

    @NotBlank
    @Email
    private String email;
}
