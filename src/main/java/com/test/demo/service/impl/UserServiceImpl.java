package com.test.demo.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.demo.entity.User;
import com.test.demo.mapper.UserMapper;
import com.test.demo.service.IUserService;
import com.test.demo.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Fbin
 * @date 2019/12/17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 爬取  https://movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        //每页多少条
        int start;
        //记录数
        int total = 0;
        //总共9979条数据
        int end = 9979;
        for (start = 0; start <= end; start += 20) {
            try {
                String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;
                JSONObject dayLine = HttpUtil.getHttpJson(address, 1);
                System.out.println("start:" + start);
                JSONArray json = dayLine.getJSONArray("data");
                List<User> list = JSON.parseArray(json.toString(), User.class);
                if (start <= end) {
                    System.out.println("已经爬取到底了");
                }
                for (User user : list) {
                   this.save(user);
                }
                total += list.size();
                System.out.println("正在爬取中---共抓取:" + total + "条数据");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
