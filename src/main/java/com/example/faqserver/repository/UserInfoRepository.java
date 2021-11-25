package com.example.faqserver.repository;

import com.example.faqserver.entity.UserInfo;
import com.example.faqserver.repository.base.BaseRepository;

import java.util.Optional;

public interface UserInfoRepository extends BaseRepository<UserInfo, Long> {

    Optional<UserInfo> getByUsername(String username);
}
