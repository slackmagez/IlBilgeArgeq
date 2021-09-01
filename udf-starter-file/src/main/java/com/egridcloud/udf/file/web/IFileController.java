/**
 * IFileController.java
 * Created at 2017-05-26
 * Created by Administrator
 * Copyright (C) 2016 egridcloud.com, All rights reserved.
 */
package com.egridcloud.udf.file.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.egridcloud.udf.core.RestResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 描述 : IFileController
 *
 * @author Administrator
 *
 */
@Api(value = "文件服务", consumes = "application/json", produces = "application/json",
    protocols = "http")
@RequestMapping(value = "/service/file")
public interface IFileController {

  /**
   * 描述 : 上传文件
   *
   * @param pathCode 路径代码
   * @param cover 是否覆盖
   * @param file 文件
   * @return 结果
   */
  @ApiOperation(value = "FILE_1", notes = "上传文件")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType = "header", name = "rmsApplicationName", value = "rms应用名称",
          required = true, dataType = "string"),
      @ApiImplicitParam(paramType = "header", name = "rmsSign", value = "rms认证秘钥", required = true,
          dataType = "string"),
      @ApiImplicitParam(paramType = "header", name = "rmsServiceCode", value = "rms接口编号",
          required = true, dataType = "string"),
      @ApiImplicitParam(paramType = "form", name = "pathCode", value = "路径代码", required = true,
          dataType = "string"),
      @ApiImplicitParam(paramType = "form", name = "cover", value = "是否覆盖", required = true,
          dataType = "boolean"),
      @ApiImplicitParam(paramType = "form", name = "file", value = "文件", required = true,
          dataType = "__file") })
  @RequestMapping(value = "upload", method = RequestMethod.POST)
  public RestResponse<String> upload(String pathCode, Boolean cover, MultipartFile file);

}
