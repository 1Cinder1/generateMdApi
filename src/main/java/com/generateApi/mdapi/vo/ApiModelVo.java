package com.generateApi.mdapi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/10 9:06
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/10 9:06
 * @updateRemark : 说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiModelVo {
  private String uri;
  private String requestMethod;
  private String description;

}
