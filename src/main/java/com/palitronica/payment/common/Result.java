package com.palitronica.payment.common;

import lombok.*;

/**
 * @author sing-fung
 * @since 1/19/2022
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Result<T>
{
    private Boolean status;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return success("success");
    }

    public static <T> Result<T> success(T data) {
        return success("success", data);
    }

    public static <T> Result<T> success(String message) {
        return success(message, null);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(true, message, data);
    }

    public static <T> Result<T> failure() {
        return failure("failure");
    }

    public static <T> Result<T> failure(T data) {
        return failure("failure", data);
    }

    public static <T> Result<T> failure(String message) {
        return new Result<T>(false, message, null);
    }

    public static <T> Result<T> failure(String message, T data) {
        return new Result<T>(false, message, data);
    }
}
