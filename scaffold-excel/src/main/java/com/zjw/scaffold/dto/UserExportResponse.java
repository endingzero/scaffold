package com.zjw.scaffold.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/04/20 11:04
 */
@Getter
@Setter
@ToString
public class UserExportResponse {

    private Long id;

    private String username;

    private String name;
}
