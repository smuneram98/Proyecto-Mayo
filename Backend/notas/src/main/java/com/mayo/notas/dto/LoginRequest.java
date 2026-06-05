package com.mayo.notas.dto;

public class LoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String useername) {
        this.username = useername;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
