package com.athhw.sprigboot006web.exception;

/*
    自定义异常类
 */
public class UserNotExitException extends RuntimeException {
    //alt+ins 添加构造器
    public UserNotExitException() {
        super("用户不存在");
    }
}
