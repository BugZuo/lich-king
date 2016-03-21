package com.flyzfq.lich.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by bug on 15/12/9.
 */
public class ApiBasicUserDTO {
  private long id;
  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
  private String email;
  private String telephone;
  @JsonProperty("is_staff")
  private boolean isStaff;
  @JsonProperty("is_active")
  private boolean isActive;
  @JsonProperty("is_super_user")
  private boolean isSuperUser;
  @JsonProperty("last_login_time")
  private Date lastLoginTime;
  @JsonProperty("created_at")
  private Date createdAt;
  private int status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
