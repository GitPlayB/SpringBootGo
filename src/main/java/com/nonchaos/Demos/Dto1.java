package com.nonchaos.Demos;

import java.util.Date;

public class Dto1 {
  private String name;

  private String sex;

  private Integer age;

  private Date birthday;

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

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getGender() {
    return sex;
  }

  @Override
  public String toString() {
    return "[name: " + this.getName() +
        " | sex: " + this.getSex() +
        " | age: " + this.getAge() +
        " | birthday: " + this.getBirthday() +
        "]";
  }
}
