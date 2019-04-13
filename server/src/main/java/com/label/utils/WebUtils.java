package com.label.utils;

import com.label.constant.HttpCode;
import com.label.vo.ResultVO;

public class WebUtils {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpCode.StatusOK);
        resultVO.setMsg("success");

        return resultVO;
    }

    public static ResultVO result(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg(data);

        return resultVO;
    }

    public static ResultVO error(Integer code, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(data);

        return resultVO;
    }
}
