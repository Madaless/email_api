package com.madaless.email_api.Form;

import javax.validation.constraints.NotNull;

public class NumberMessage {

  @NotNull
  private Long magic_number;

  public NumberMessage(@NotNull Long magic_number) {
    this.magic_number = magic_number;
  }

  public NumberMessage() {
  }

  public Long getMagic_number() {
    return magic_number;
  }

  public void setMagic_number(Long magic_number) {
    this.magic_number = magic_number;
  }

  @Override
  public String toString() {
    return "NumberMessage{" +
        "magic_number=" + magic_number +
        '}';
  }
}
