package ua.lviv.wdelivery.auth.service;

import ua.lviv.wdelivery.auth.model.User;

import java.util.Optional;

public interface UserService {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
    Optional<User> findUserByResetToken(String resetToken);
    void save(User user);
}
