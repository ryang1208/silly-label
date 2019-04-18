package com.label.util;

import com.label.util.constant.HttpCode;
import com.label.vo.ResultVO;

public class WebUtils {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpCode.StatusOK);
        resultVO.setData("success");

        return resultVO;
    }

    public static ResultVO result(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpCode.StatusOK);
        resultVO.setData(data);

        return resultVO;
    }

    public static ResultVO result(Integer code, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setData(data);

        return resultVO;
    }

    public static ResultVO error(Integer code, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setData(data);

        return resultVO;
    }
}
