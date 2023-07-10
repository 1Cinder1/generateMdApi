package com.generateApi.mdapi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/10 9:10
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/10 9:10
 * @updateRemark : 说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModelVo {
  private String name;
  private String type;
  private boolean isFixed;
  private String description;
}
