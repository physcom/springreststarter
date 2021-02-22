package io.qtechdigital.onlineTutoring.controller.api.v1;

import io.qtechdigital.onlineTutoring.dto.user.UserDto;
import io.qtechdigital.onlineTutoring.dto.user.request.UserUpdateDto;
import io.qtechdigital.onlineTutoring.model.User;
import io.qtechdigital.onlineTutoring.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") User user){

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<User> listAll(){
        return userService.getAll();
    }

    @PostMapping("/edit/{id}")
    public User edit(
            @Valid @RequestBody UserUpdateDto source,
            @PathVariable(name = "id") User target
    ) {
        return userService.update(target, source);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(
            @PathVariable(name = "id") Long id
    ) {
        userService.delete(id);
        return true;
    }

}
