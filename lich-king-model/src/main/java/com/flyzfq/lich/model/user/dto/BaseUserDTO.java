package com.flyzfq.lich.model.user.dto;

import java.util.Date;

/**
 * Created by bug on 16/3/18.
 */
public class BaseUserDTO {
  private long id;
  private String username;
  private String avatar;
  private String firstName;
  private String lastName;
  private String email;
  private String telephone;
  private String bindSite;
  private boolean isStaff;
  private boolean isActive;
  private boolean isSuperUser;
  private Date lastLoginTime;
  private Date createdAt;
  private int status;

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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getBindSite() {
    return bindSite;
  }

  public void setBindSite(String bindSite) {
    this.bindSite = bindSite;
  }

  public boolean isStaff() {
    return isStaff;
  }

  public void setStaff(boolean staff) {
    isStaff = staff;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public boolean isSuperUser() {
    return isSuperUser;
  }

  public void setSuperUser(boolean superUser) {
    isSuperUser = superUser;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
