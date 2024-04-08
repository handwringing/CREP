package com.sample;


public class User {

  private long userId;
  private String username;
  private String password;
  private String email;
  private String phoneNumber;
  private java.sql.Timestamp registerDate;
  private long creditScore;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public java.sql.Timestamp getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(java.sql.Timestamp registerDate) {
    this.registerDate = registerDate;
  }


  public long getCreditScore() {
    return creditScore;
  }

  public void setCreditScore(long creditScore) {
    this.creditScore = creditScore;
  }

}
