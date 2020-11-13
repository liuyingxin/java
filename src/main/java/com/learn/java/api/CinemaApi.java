package com.learn.java.api;

import com.learn.java.response.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.learn.java.bean.vo.CinemaVo;
import com.learn.java.bean.dto.CinemaDto;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(value = {"/Cinema"})
@Validated
public interface CinemaApi{
   
    @ApiOperation("分页查询列表")
    @PostMapping("/getList")
    ApiResult<List<CinemaVo>> getList(@Validated @RequestBody CinemaDto cinemaDto);

    @ApiOperation("新增数据")
    @PostMapping("/addInfos")
    ApiResult addInfos(@Validated @RequestBody CinemaDto cinemaDto);

    @ApiOperation("修改数据")
    @PostMapping("/updateInfo")
    ApiResult updateInfo(@Validated @RequestBody CinemaDto cinemaDto);

    @ApiOperation("通过id查询详情")
    @GetMapping("/getById/{id}")
    ApiResult<CinemaVo> getById(@ApiParam(value = "ID", example = "1", required = true)
                                              @NotNull @PathVariable Integer id);
                                              
    @ApiOperation("通过id删除数据")
    @PostMapping("/deleteInfo")
    ApiResult deleteInfo(@ApiParam(value = "ID", example = "1", required = true)
                                              @NotNull @PathVariable Integer id);

}