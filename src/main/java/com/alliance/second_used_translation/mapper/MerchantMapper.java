package com.alliance.second_used_translation.mapper;

import com.alliance.second_used_translation.domain.Merchant;

import java.util.List;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    int getMerchantCount();

    List<Merchant> getAllMerchants();

    Merchant selectByName(String name);
}