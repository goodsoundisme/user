package com.sparta.user.dto;

import lombok.Getter;

@Getter
public class UserDetailResponseDto {
    private final Long id;
    private final String username;

    public UserDetailResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
