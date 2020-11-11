package com.learn.java.api;

import com.learn.java.response.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * (Information)API类
 *
 * @author xin.framework
 * @since 2020-04-07 15:46:43
 */

@Api(tags = "个人信息模块")
@RequestMapping(value = {"/Information"})

public interface InformationApi {

    @ApiOperation(value = "根据姓名获取信息")
    @GetMapping("/getInfo_byName")
    @ApiParam(value = "姓名", required = true)
    ApiResult getInfoByName(@RequestParam(value="name") String name);
}