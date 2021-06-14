package com.alliance.second_used_translation.controller;

import com.alliance.second_used_translation.domain.Good;
import com.alliance.second_used_translation.mapper.GoodMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@Slf4j
public class GoodController {

    @Autowired
    GoodMapper goodMapper;


    private int goodNumber;

    @RequestMapping(value = "/goodCount",method =RequestMethod.GET)
    public int goodCount(){
        return goodMapper.getGoodCount();
    }

    @RequestMapping("/goods")
    public List<Good> getGoods(){
        log.info("有人在尝试获取商品数据...");
        return goodMapper.getAllGoods();
    }

    @RequestMapping("/findGoodById")
    public Good findGoodById(@RequestParam(value = "id") int id){
        log.info("正在获取 " + id +" 号货物");
        return goodMapper.selectByPrimaryKey(id);
    }


    @RequestMapping("/findGoodByCategory")
    public List<Good> findGoodByCategory(@RequestParam(value = "category") String category){
        return goodMapper.selectByCategory(category);
    }

    @RequestMapping("/findGoodByName")
    public List<Good> findGoodByName(@RequestParam(value = "name") String name){
        return goodMapper.selectByName(name);
    }

    @RequestMapping("/findGoodByOwner")
    public List<Good> findGoodByOwner(@RequestParam(value = "owner") String owner){
        log.info(owner + "在查询它的商品");
        return goodMapper.selectByOwner(owner);
    }

    @RequestMapping("/findGoodByUpdateBy")
    public List<Good> findGoodByUpdateBy(@RequestParam(value = "updateBy") String updateBy){
        log.info(updateBy + "在查询它的购买");
        return goodMapper.selectByUpdateBy(updateBy);
    }

    @PostMapping("/addGoodB")
    public int addGoodB(@RequestBody Good good){
        goodNumber = goodMapper.getGoodCount();

        while (true) {
            if (goodMapper.selectByPrimaryKey(goodNumber + 1) == null) {
                good.setId(goodNumber + 1);
                break;
            } else {
                goodNumber++;
                continue;
            }
        }
        good.setInsertBy("merchant_id");
        good.setInsertAt(new Date());
        good.setUpdateBy("merchant_id");
        good.setUpdateAt(new Date());
        good.setIsValid(1);

        return goodMapper.insert(good) == 1? 200 : 201;
    }

    @PostMapping("/addGood")
    public int addGood(@RequestParam(value = "name") String name,
                       @RequestParam(value = "category") String category,
                       @RequestParam(value = "size") String size,
                       @RequestParam(value = "used_degree") String used_degree,
                       @RequestParam(value = "repertory") String repertory,
                       @RequestParam(value = "good_snap") String good_snap,
                       @RequestParam(value = "merchant_id") String merchant_id){

        Good good = new Good();

        goodNumber = goodMapper.getGoodCount();

        while (true) {
            if (goodMapper.selectByPrimaryKey(goodNumber + 1) == null) {
                good.setId(goodNumber + 1);
                break;
            } else {
                goodNumber++;
                continue;
            }
        }

        good.setUsedDegree("123");

        good.setName(name);
        good.setCategory(category);
        good.setIsValid(1);
        good.setRepertory(repertory);
        good.setGoodSnap(good_snap);
        good.setSize(size);

        good.setInsertBy("merchant_id");
        good.setInsertAt(new Date());
        good.setUpdateBy("merchant_id");
        good.setUpdateAt(new Date());


        return goodMapper.insert(good) == 1? 200 : 201;



    }

    @PostMapping("/updateGoodB")
    public int updateGoodB(@RequestBody Good good){

        good.setIsValid(1);
        good.setUpdateBy(good.getInsertBy());
        good.setUpdateAt(new Date());

        return goodMapper.updateByPrimaryKey(good) == 1 ? 205 : 206;
    }

    @PostMapping("/purchase")
    public int purchase(@RequestParam(value = "name") String name,@RequestBody Good good){

        log.info("有人在买东西.....");
        good.setIsValid(1);
        good.setUpdateBy(name);
        good.setUpdateAt(new Date());

        return goodMapper.updateByPrimaryKey(good) == 1 ? 205 : 206;
    }

    @PostMapping("updateGood")
    public int updateGood(@RequestParam(value = "id") int id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "category") String category,
                          @RequestParam(value = "size") String size,
                          @RequestParam(value = "used_degree") String used_degree,
                          @RequestParam(value = "repertory") String repertory,
                          @RequestParam(value = "good_snap") String good_snap,
                          @RequestParam(value = "merchant_id") String merchant_id){

        Good good = new Good();

        good.setId(id);

        good.setUsedDegree(used_degree);
        good.setName(name);
        good.setSize(size);
        good.setRepertory(repertory);
        good.setGoodSnap(good_snap);
        good.setCategory(category);
        good.setIsValid(1);
        good.setUpdateBy(merchant_id);
        good.setUpdateAt(new Date());

        return goodMapper.updateByPrimaryKey(good) == 1 ? 205 : 206;

    }

    @DeleteMapping("/deleteGood")
    public int deleteGood(@RequestParam(value = "id") int id){
        Good good = goodMapper.selectByPrimaryKey(id);
        if (good == null){
            return 204;
        }

        good.setIsValid(0);
        good.setUpdateBy(id+"");
        good.setUpdateAt(new Date());

        return goodMapper.updateByPrimaryKey(good) == 1 ? 303 : 304;
    }






}
