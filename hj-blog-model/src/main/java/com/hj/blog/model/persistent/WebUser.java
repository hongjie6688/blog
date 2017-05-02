package com.hj.blog.model.persistent;

import com.hj.blog.common.authorization.AuthorizationHelper;
import lombok.Data;

@Data
public class WebUser extends BaseModel {
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String username;

    private String password;

    private String passwordSalt;

    private String nickname;

    private Boolean enable;

    private String token;

    public void encodePassword() {
        this.password = AuthorizationHelper.encodePassword(this.password, this.passwordSalt);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(AuthorizationHelper.encodePassword(password, this.passwordSalt));
    }

    public void generateToken() {
        this.token = AuthorizationHelper.generateToken(this.username, this.password);
    }

}