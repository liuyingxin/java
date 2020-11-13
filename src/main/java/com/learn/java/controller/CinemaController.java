package com.learn.java.controller;

import com.learn.java.api.CinemaApi;
import com.learn.java.bean.dto.CinemaDto;
import com.learn.java.bean.vo.CinemaVo;
import com.learn.java.response.ApiResult;
import com.learn.java.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * (Cinema)表控制层
 *
 * @author mybatisplus_my
 * @since 2020-11-13 14:33:05
 */

@RestController
public class CinemaController implements CinemaApi {
    @Autowired
    private CinemaService cinemaService;

    @Override
    public ApiResult<List<CinemaVo>> getList(CinemaDto cinemaDto) {
        return null;
    }

    @Override
    public ApiResult addInfos(CinemaDto cinemaDto) {
        return null;
    }

    @Override
    public ApiResult updateInfo(CinemaDto cinemaDto) {
        return null;
    }

    @Override
    public ApiResult<CinemaVo> getById(@NotNull Integer id) {
        return null;
    }

    @Override
    public ApiResult deleteInfo(@NotNull Integer id) {
        return null;
    }
}