package com.rbac.exception;

import com.rbac.common.ActionResult;
import com.rbac.common.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    /**
     * 参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ActionResult processMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        log.error(e.getMessage(), e.getCause());

        return new ActionResult(StatusCode.IllegalArgument,e.getMessage());

    }

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ActionResult processExcption( BusinessException e) {
        log.error(e.getMessage(), e.getCode());
        return new ActionResult(e.getCode(), e.getMessage() + ":" + e.getValue(), e.getValue());
    }

}
