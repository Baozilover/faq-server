package com.example.repository;

import com.example.entity.UserInfo;
import com.example.repository.base.BaseRepository;

import java.util.Optional;

public interface UserInfoRepository extends BaseRepository<UserInfo, Long> {

    Optional<UserInfo> getByUsername(String username);
}
