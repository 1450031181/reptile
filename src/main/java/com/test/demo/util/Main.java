//package com.test.demo.util;
//
//import cn.hutool.json.JSONArray;
//import cn.hutool.json.JSONObject;
//import com.alibaba.fastjson.JSON;
//import com.test.demo.entity.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
///**
// * @author Fbin
// * @date 2020/2/14
// */
//public class Main {
//    public static void main(String[] args) {
//        //定义配置文件路径
//        int start;//每页多少条
//        int total = 0;//记录数
//        int end = 9979;//总共9979条数据
//        for (start = 0; start <= end; start += 20) {
//            try {
//                String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;
//                JSONObject dayLine = HttpUtil.getHttpJson(address, 1);
//                System.out.println("start:" + start);
//                JSONArray json = dayLine.getJSONArray("data");
//                List<User> list = JSON.parseArray(json.toString(), User.class);
//                if (start <= end) {
//                    System.out.println("已经爬取到底了");
//                }
//                for (User movie : list) {
//                    movieMapper.insert(movie);
//                    sqlSession.commit();
//                }
//                total += list.size();
//                System.out.println("正在爬取中---共抓取:" + total + "条数据");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
