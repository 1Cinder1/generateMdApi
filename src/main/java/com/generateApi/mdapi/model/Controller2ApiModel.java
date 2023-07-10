package com.generateApi.mdapi.model;

import com.generateApi.mdapi.vo.ApiModelVo;
import com.generateApi.mdapi.vo.RequestModelVo;
import com.generateApi.mdapi.vo.ResponseModelVo;

import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/10 9:03
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/10 9:03
 * @updateRemark : 说明本次修改内容
 */

public class Controller2ApiModel {
  public static String getApiModel(ApiModelVo apiModelVo, List<RequestModelVo> requestModelVos, List<ResponseModelVo> responseModelVos){
    String model = "| 接口 | "+apiModelVo.getUri()+"                                         |\n" +
      "| ---- | ------------------------------------------------------------ |\n" +
      "| 描述 | "+apiModelVo.getDescription()+"                                                 |\n" +
      "| 验证 | Token，客户端验证，参数：<br />Header中：<br />**Authorization:** ==Bearer {token} |\n" +
      "| 方法 | "+apiModelVo.getRequestMethod()+"                                                         |\n" +
      "\n" +
      "**Request**\n" +
      "| 参数名        | 类型   | 是否必须 | 参数位置    | 描述           |\n" +
      "| ------------- | ------ | -------- | ----------- | -------------- |\n"+
      "| Authorization | String  | Y        | header     | 用户Token，Bearer协议 \n"+

      getRequestModel(requestModelVos)+
      "\n**Response**\n" +
      "\n" +
        "\n" +"| 参数名         | 类型       | 是否必须 | 描述                        |\n"+
        "| -------------- | ---------- | -------- | --------------------------- |\n"
      +
      getResponseModel(responseModelVos);
    return model;
  }

  private static String getResponseModel(List<ResponseModelVo> responseModelVos) {
    if (responseModelVos.size() == 0) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (ResponseModelVo responseModelVo : responseModelVos) {
      stringBuilder.append(
        "| "+responseModelVo.getName()+
        "           | "+responseModelVo.getType()+
        " | "+(responseModelVo.isFixed()==false?"N":"Y")+
        "        | "+responseModelVo.getDescription()+"                    |\n"
      );
    }
    stringBuilder.append("\n\n");
    return stringBuilder.toString();
  }

  private static String getRequestModel(List<RequestModelVo> requestModelVos){
    if (requestModelVos.size()==0) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (RequestModelVo requestModelVo : requestModelVos) {
      stringBuilder.append(
        "| "+requestModelVo.getParamName()+" | "+
          requestModelVo.getParamType()+" | "+
          (requestModelVo.isNecessary()==false?"N":"Y")+
          "        | "+requestModelVo.getParamLocation()+
          "      | "+requestModelVo.getParamDescription()+" |\n"
      );
    }
    stringBuilder.append("\n");
    return stringBuilder.toString();
  }
}
