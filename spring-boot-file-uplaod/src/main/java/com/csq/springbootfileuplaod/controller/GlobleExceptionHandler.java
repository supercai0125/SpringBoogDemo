package com.csq.springbootfileuplaod.controller;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author ercai
 * @date 2020/1/9 - 10:19
 */
@ControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(MultipartException.class)//申明要捕获的错误类型
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        System.out.println("aaa");
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:uploadStatus";
    }
}
