package org.example.bigevent.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Password {
    @NotEmpty(message = "原密码不能为空")
    private String old_pwd;
    @NotEmpty(message = "请输入新密码")
    @Pattern(regexp = "^\\S{5,16}$", message = "密码长度为5-16")
    private String new_pwd, re_pwd;
}
