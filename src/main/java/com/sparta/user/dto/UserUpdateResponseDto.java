package com.sparta.user.dto;

import lombok.Getter;

@Getter
public class UserUpdateResponseDto {
    private final Long id;
    private final String name;

    public UserUpdateResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
