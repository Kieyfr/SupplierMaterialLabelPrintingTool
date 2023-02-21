package com.xydz.suppliermateriallabelprintingtool.config;

/**
 * @Author xiachenchen
 * @ClassName: NoteException
 * @Description: 自定义异常 TODO
 * @Date 2022/11/22
*/
public class NoteException extends RuntimeException {


    private int code;

    public NoteException(String message) {
        this(message, 0);
    }

    public NoteException(String message, int code) {
        super(message);

        this.code = code;
    }

    public NoteException(Throwable cause) {
        this(cause, 0);
    }

    public NoteException(Throwable cause, int code) {
        super(cause);

        this.code = code;
    }

    public int getCode() {
        return code;
    }


}
