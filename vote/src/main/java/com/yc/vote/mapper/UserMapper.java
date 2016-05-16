package com.yc.vote.mapper;

import java.util.List;

import com.yc.vote.entity.User;

public interface UserMapper {
	User Login(User user);

	int Register(User user);
}