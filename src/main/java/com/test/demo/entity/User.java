package com.test.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Fbin
 * @date 2019/12/17
 */
@Data
public class User implements Serializable {
    @TableId
    private String id;
    private String directors;
    private String rate;
    private String title;
    private String url;
    private String casts;
    private String cover;
}
