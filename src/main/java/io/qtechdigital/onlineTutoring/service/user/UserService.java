package io.qtechdigital.onlineTutoring.service.user;

import io.qtechdigital.onlineTutoring.dto.user.request.UserUpdateDto;
import io.qtechdigital.onlineTutoring.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User update(User user, UserUpdateDto userDto);

    List<User> getAll();

    User findByEmail(String email);

    User findById(Long id);

    boolean existByEmail(String email);

    void delete(Long id);
}
