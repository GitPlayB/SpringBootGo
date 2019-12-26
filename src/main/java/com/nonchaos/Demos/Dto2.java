package com.nonchaos.Demos;

public class Dto2 {
  private Dto1 dto1;

  public Dto1 getDto1() {
    return dto1;
  }

  public void setDto1(Dto1 dto1) {
    this.dto1 = dto1;
  }

  @Override
  public String toString() {
    return "[object: " + this.getDto1().toString() +
        "]";
  }
}
