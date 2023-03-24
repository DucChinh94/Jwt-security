package com.chinhnd.security.dto.response;

import com.chinhnd.security.common.Constrants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int status;

    private String message;

    private Object item;

    public static ApiResponse ApiResponseSuccess(Object item) {
        return new ApiResponse(Constrants.HTTP_CODE_200, Constrants.SUCCESS, item);
    }
}
