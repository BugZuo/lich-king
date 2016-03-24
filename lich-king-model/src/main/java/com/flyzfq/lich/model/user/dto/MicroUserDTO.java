package com.flyzfq.lich.model.user.dto;

/**
 * Created by bug on 16/3/18.
 */
public class MicroUserDTO {
  private long id;
  private String username;
  private String avatar;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
