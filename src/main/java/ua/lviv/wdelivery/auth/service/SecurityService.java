package ua.lviv.wdelivery.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String email, String password);
}
