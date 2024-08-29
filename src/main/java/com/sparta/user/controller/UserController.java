package com.sparta.user.controller;

import com.sparta.user.dto.*;
import com.sparta.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return ResponseEntity.ok(userService.saveUser(userSaveRequestDto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUser(){
        return ResponseEntity.ok(userService.getUser());
    }

    @GetMapping("/users/{usersID}")
    public ResponseEntity<UserDetailResponseDto> getUserDetail(@PathVariable Long userID){
        return ResponseEntity.ok(userService.getUserDetail(userID));
    }

    @GetMapping("/users/{usersId}")
    public ResponseEntity<UserUpdateResponseDto> updateUser(@PathVariable Long userID, @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        return ResponseEntity.ok(userService.updateUser(userID,userUpdateRequestDto));
    }

    @DeleteMapping("/users/{usersId}")
    public void deleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
    }
}
