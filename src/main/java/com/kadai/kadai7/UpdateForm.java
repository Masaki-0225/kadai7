package com.kadai.kadai7;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UpdateForm {
    @NotEmpty(message = "名前を入力してね！！")
    @Size(max = 13, message = "名前は１３文字以内で！！")
    private String name;
    @Min(value = 18, message = "18才未満はご利用いただけません。")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
