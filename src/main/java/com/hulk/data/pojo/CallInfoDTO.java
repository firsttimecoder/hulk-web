package com.hulk.data.pojo;

import com.hulk.data.model.CallInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by vijayvar on 10/20/15.
 */
@Data
public class CallInfoDTO {

    private Long id;

    private String customerName;

    public static CallInfoDTO from(CallInfo callInfo) {
        CallInfoDTO callInfoDTO = new CallInfoDTO();
        BeanUtils.copyProperties(callInfo, callInfoDTO);

        return callInfoDTO;
    }
}
