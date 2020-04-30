package com.nonchaos.Demos;

import java.util.Date;

public class Dto3 {
  private String name;

  private String sex;

  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return sex;
  }

  @Override
  public String toString() {
    return "[name: " + this.getName() +
        " | sex: " + this.getSex() +
        " | age: " + this.getAge() +
        "]";
  }
}
