package com.alliance.second_used_translation.controller;


import com.alliance.second_used_translation.domain.Merchant;
import com.alliance.second_used_translation.domain.User;
import com.alliance.second_used_translation.mapper.MerchantMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class MerchantController {

    @Autowired
    MerchantMapper merchantMapper;

    @RequestMapping("/merchantCount")
    public int merchantCount(){
        return merchantMapper.getMerchantCount();
    }

    @RequestMapping("/merchants")
    public List<Merchant> getMerchants(){
        return merchantMapper.getAllMerchants();
    }

    @RequestMapping("/findByMerchantByName")
    public Merchant findByMerchantByName(String name){
        Merchant merchant = merchantMapper.selectByName(name);

        return merchant;
    }
    @PostMapping("/loginUpM")
    @ResponseBody
    public int loginUp(@RequestBody Merchant merchant) {
        log.info(merchant.getName() + " 在尝试登录..... " );
        if (merchantMapper.selectByName(merchant.getName()) != null) {
            return 107;
        }

        return 108;
    }


    @RequestMapping("findMerchantById")
    public Merchant findMerchantById(int id){
        Merchant merchant = merchantMapper.selectByPrimaryKey(id);
        return merchant;
    }

    @PostMapping("addMerchantB")
    public int addMerchantB(@RequestBody Merchant merchant){
        int merchantNumber = merchantMapper.getMerchantCount();

        while (true) {
            if (merchantMapper.selectByPrimaryKey( merchantNumber + 1) == null) {
                if (merchantMapper.selectByName(merchant.getName()) == null) {
                    merchant.setId(merchantNumber + 1);
                    break;
                } else {
                    //店名重复
                    return 301;
                }
            } else {
                merchantNumber++;
                continue;
            }
        }

        merchant.setShopCardSnap("shop_card_snap");
        merchant.setIdCardSnap("id_card_snap");

        merchant.setUpdateAt(new Date());
        merchant.setInsertAt(new Date());
        merchant.setUpdateBy(merchant.getName());
        merchant.setInsertBy(merchant.getName());
        merchant.setIsValid(1);

        return merchantMapper.insert(merchant) == 1 ? 300 : 302;
    }


    @PostMapping("/addMerchant")
    public int addMerchant(@RequestParam(value = "name") String name,
                           @RequestParam(value = "gender") String gender,
                           @RequestParam(value = "shop_card_snap") String shop_card_snap,
                           @RequestParam(value = "id_card_snap") String id_card_snap){

        int merchantNumber = merchantMapper.getMerchantCount();
        Merchant merchant = new Merchant();

        while (true) {
            if (merchantMapper.selectByPrimaryKey( merchantNumber + 1) == null) {
                if (merchantMapper.selectByName(name) == null) {
                    merchant.setId(merchantNumber + 1);
                    break;
                } else {
                    //店名重复
                    return 301;
                }
            } else {
                merchantNumber++;
                continue;
            }
        }

        merchant.setName(name);
        merchant.setGender(gender);
        merchant.setShopCardSnap(shop_card_snap);
        merchant.setIdCardSnap(id_card_snap);

        merchant.setUpdateAt(new Date());
        merchant.setInsertAt(new Date());
        merchant.setUpdateBy(name);
        merchant.setInsertBy(name);
        merchant.setIsValid(1);

        return merchantMapper.insert(merchant) == 1 ? 300 : 302;


    }

    @PostMapping("/updateMerchant")
    public int updateMerchant(@RequestParam(value = "name") String name,
                              @RequestParam(value = "id") int id,
                              @RequestParam(value = "gender") String gender,
                              @RequestParam(value = "shop_card_snap") String shop_card_snap,
                              @RequestParam(value = "id_card_snap") String id_card_snap){

        Merchant merchant = new Merchant();


        merchant.setId(id);
        merchant.setName(name);
        merchant.setGender(gender);
        merchant.setShopCardSnap(shop_card_snap);
        merchant.setIdCardSnap(id_card_snap);

        merchant.setUpdateAt(new Date());
        merchant.setUpdateBy("name");

        return merchantMapper.updateByPrimaryKeySelective(merchant) == 1 ? 305 : 306;

    }

    @DeleteMapping("/deleteMerchant")
    public int deleteMerchant(@RequestParam(value = "id") int id){
        Merchant merchant = merchantMapper.selectByPrimaryKey(id);

        if (merchant == null){
            return 304;
        }

        merchant.setIsValid(0);

        return merchantMapper.updateByPrimaryKey(merchant) == 1 ? 303 : 304;
    }



}
