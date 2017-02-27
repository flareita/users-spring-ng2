package it.flare.ddd.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{
Long id;
String username;
String password;
String email;
Long serial;

public Long getSerial() {
	return serial;
}
public void setSerial(Long version) {
	this.serial = version;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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

}
