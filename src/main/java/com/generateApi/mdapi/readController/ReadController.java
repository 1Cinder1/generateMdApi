package com.generateApi.mdapi.readController;

import com.explore2020.uaa.vo.response.ResponseBean;
import com.generateApi.mdapi.constant.ParamLocation;
import com.generateApi.mdapi.constant.RequestMethod;
import com.generateApi.mdapi.model.Controller2ApiModel;
import com.generateApi.mdapi.vo.ApiModelVo;
import com.generateApi.mdapi.vo.RequestModelVo;
import com.generateApi.mdapi.vo.ResponseModelVo;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/9 21:34
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/9 21:34
 * @updateRemark : 说明本次修改内容
 */

public class ReadController {
  public static void main(String[] args) {
    String rootPath = System.getProperty("user.dir");
    File rootFiles = new File(rootPath);
    for (File file : rootFiles.listFiles()) {
      if (!file.isDirectory()) {
        continue;
      }
      String fileName = file.getName();
      if (fileName.contains(".")||fileName.contains("out")){
        continue;
      }
      String stablePath = "\\src\\main\\java";
      String basicPath = rootPath + "\\" + fileName + stablePath;
      generateMD(cdController(basicPath,""));
    }
  }

  private static List cdController(String basicPath, String packageName){
    File basicFile = new File(basicPath);
    File[] listFiles = basicFile.listFiles();
    if (listFiles.length == 1) {
      String packName = listFiles[0].getName();
      String nextPackageName;
      if (packageName.isEmpty()) {
        nextPackageName = packName;
      }else {
        nextPackageName = packageName + "."+packName;
      }
      return cdController(basicPath +"\\"+ packName,nextPackageName);
    }
    for (File listFile : listFiles) {
      String fileName = listFile.getName();
      if (fileName.contains("controller")) {
        ArrayList<String> strings = new ArrayList<>();
        //controller路径
        strings.add(basicPath + "\\" + fileName);
        //controller中的类的包名
        strings.add(packageName+"."+fileName);
        return strings;
      }
    }
    return null;
  }

  private static void generateMD( List<String> paths){
    if (paths == null){
      return;
    }
    String rootPath = System.getProperty("user.dir");
    rootPath = rootPath+"/generateMdApi/";
    String src = rootPath + "src/main/java/com/generateApi/mdapi/target/";
    File controllerDir = new File(paths.get(0));
    for (File file : controllerDir.listFiles()) {
      java2MD(file,src,paths.get(1));
    }
  }

  private static void java2MD(File file,String target, String packageName) {
    String fileName = file.getName();
    String[] splitName = fileName.split("\\.");
    Class<?> aClass;
    try {
      aClass = Class.forName(packageName+"."+splitName[0]);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    RequestMapping annotation = aClass.getAnnotation(RequestMapping.class);
    Method[] methods = aClass.getDeclaredMethods();
    StringBuilder stringBuilder = new StringBuilder();
    // 自定义比较器
    Comparator<Method> methodComparator = new Comparator<Method>() {
      @Override
      public int compare(Method m1, Method m2) {
        // 按方法名的长度进行排序，长度较短的方法在前
        return m1.getName().compareTo(m2.getName());
      }
    };
    Arrays.sort(methods, methodComparator);
    int count = 1;
    for (Method method : methods) {
      ApiModelVo apiModelVo = getApiModelVo(annotation.value()[0],method);
      ArrayList<RequestModelVo> requestModelVo = getRequestParams(method);
      ArrayList<ResponseModelVo> responseModelVo = getResponseModelVo(method);
      if (apiModelVo == null){
        break;
      }
      Description description = method.getAnnotation(Description.class);
      if (description !=null) {
        stringBuilder.append("#### 1."+count++ +" "+method.getName()+"\n\n");
      }else{
        stringBuilder.append("#### 1."+count++ +"\n\n");
      }
      stringBuilder.append(Controller2ApiModel.getApiModel(apiModelVo,requestModelVo,responseModelVo));
    }
    try(BufferedWriter writer =new BufferedWriter(new FileWriter(target + splitName[0]+".md"))){
      writer.write(stringBuilder.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  private static ArrayList<ResponseModelVo> getResponseModelVo(Method method) {
    ArrayList<ResponseModelVo> responseModelVos = new ArrayList<>();
    Class<?> returnType = method.getReturnType();

    if (returnType.isAssignableFrom(ResponseBean.class)) {
      for (Field declaredField : returnType.getDeclaredFields()) {
        ResponseModelVo responseModelVo = new ResponseModelVo();
        String[] split = declaredField.getType().toString().split("\\.");
        responseModelVo.setType(split[split.length-1]);
        responseModelVo.setName(declaredField.getName());
        responseModelVo.setFixed(true);
        responseModelVos.add(responseModelVo);
      }
    }
    return responseModelVos;
  }

  private static ArrayList<RequestModelVo> getRequestParams(Method method) {
    ArrayList<RequestModelVo> requestModelVos = new ArrayList<>();
    for (Parameter parameter : method.getParameters()) {
      RequestModelVo requestModelVo = new RequestModelVo();
      requestModelVo.setParamName(parameter.getName());
      String[] split = parameter.getType().toString().split("\\.");
      requestModelVo.setParamType(split[split.length-1]);
      Map<String, String> paramLocation = getParamLocation(parameter);
      requestModelVo.setParamLocation(paramLocation.get("localtion"));
      requestModelVo.setNecessary(Boolean.valueOf(paramLocation.get("isNecessary")));
      requestModelVos.add(requestModelVo);
    }
    return requestModelVos;
  }

  private static Map<String,String> getParamLocation(Parameter parameter) {
    HashMap<String, String> hashMap = new HashMap<>();
    if (parameter.isAnnotationPresent(RequestBody.class)) {
      hashMap.put("localtion",ParamLocation.body.toString());
      RequestBody annotation = parameter.getAnnotation(RequestBody.class);
      hashMap.put("isNecessary",String.valueOf(annotation.required()));
      return hashMap;
    }else if (parameter.isAnnotationPresent(RequestParam.class)){
      hashMap.put("localtion",ParamLocation.url.toString());
      RequestParam annotation = parameter.getAnnotation(RequestParam.class);
      hashMap.put("isNecessary",String.valueOf(annotation.required()));
      return hashMap;
    }else if (parameter.isAnnotationPresent(RequestHeader.class)){
      hashMap.put("localtion",ParamLocation.header.toString());
      RequestHeader annotation = parameter.getAnnotation(RequestHeader.class);
      hashMap.put("isNecessary",String.valueOf(annotation.required()));
      return hashMap;
    }
    return null;
  }

  private static ApiModelVo getApiModelVo(String baseUri, Method method){
    ApiModelVo apiModelVo = new ApiModelVo();
    Description description = method.getAnnotation(Description.class);
    if (method.isAnnotationPresent(GetMapping.class)) {
      GetMapping annotation = method.getAnnotation(GetMapping.class);
      apiModelVo.setRequestMethod(RequestMethod.GET.toString());
      apiModelVo.setUri(baseUri+annotation.value()[0]);
      if (description != null){
        apiModelVo.setDescription(description.value());
      }
      return apiModelVo;
    }else if (method.isAnnotationPresent(PostMapping.class)) {
      PostMapping annotation = method.getAnnotation(PostMapping.class);
      apiModelVo.setRequestMethod(RequestMethod.POST.toString());
      apiModelVo.setUri(baseUri+annotation.value()[0]);
      if (description != null){
        apiModelVo.setDescription(description.value());
      }
      return apiModelVo;
    }else if (method.isAnnotationPresent(PutMapping.class)) {
      PutMapping annotation = method.getAnnotation(PutMapping.class);
      apiModelVo.setRequestMethod(RequestMethod.PUT.toString());
      apiModelVo.setUri(baseUri+annotation.value()[0]);
      if (description != null){
        apiModelVo.setDescription(description.value());
      }
      return apiModelVo;
    }
    return null;
  }



}
