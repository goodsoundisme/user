package com.sparta.user.service;

import com.sparta.user.dto.*;
import com.sparta.user.entity.User;
import com.sparta.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {
        User user = new User();
        User savedUser = userRepository.save(user);

        return new UserSaveResponseDto(savedUser.getId(), savedUser.getName());
    }

    public List<UserSimpleResponseDto> getUser(){
       List<User> userList =userRepository.findAll();

       List<UserSimpleResponseDto> dtoList = new ArrayList<>();
       for(User user: userList){
           UserSimpleResponseDto dto = new UserSimpleResponseDto(user.getId(), user.getName());
           dtoList.add(dto);
       }
               return dtoList;
    }

    public UserDetailResponseDto getUserDetail(Long userID){
        User user = userRepository.findById(userID).orElseThrow(()->new NullPointerException("유저가 존재하지 않습니다."));

        return new UserDetailResponseDto(user.getId(), user.getName());
    }

    @Transactional
    public UserUpdateResponseDto updateUser(Long userID, UserUpdateRequestDto userUpdateRequestDto) {
         User user = userRepository.findById(userID).orElseThrow(()->new NullPointerException("유저가 존재하지 않습니다."));

         return new UserUpdateResponseDto(user.getId(), user.getName());
    }

    @Transactional
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }
}
























