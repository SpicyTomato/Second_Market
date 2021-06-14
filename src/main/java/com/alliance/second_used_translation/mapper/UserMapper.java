package com.alliance.second_used_translation.mapper;

import com.alliance.second_used_translation.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int getUsersCount();

    User selectByName(String name);

    List<User> getAllUsers();
}