package com.alliance.second_used_translation.mapper;

import com.alliance.second_used_translation.domain.Good;

import java.util.List;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);

    int getGoodCount();

    List<Good> getAllGoods();

    List<Good> selectByCategory(String category);

    List<Good> selectByName(String name);

    List<Good> selectByOwner(String owner);

    List<Good> selectByUpdateBy(String updateBy);

}