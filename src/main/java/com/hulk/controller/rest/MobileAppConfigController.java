package com.hulk.controller.rest;

import com.hulk.enums.CallStatus;
import com.hulk.enums.IndianCity;
import com.hulk.enums.IndianState;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vijayvar on 10/28/15.
 */
@RestController
@RequestMapping("/mobileAppConfig")
public class MobileAppConfigController {

    @RequestMapping(value = "/getEnumValues/{enumString}", method = RequestMethod.GET)
    public @ResponseBody Object[] getEnumValues(@PathVariable String enumString) {
        switch (enumString) {
            case "IndianCity":
                return IndianCity.values();
            case "IndianState":
                return IndianState.values();
            case "CallStatus":
                return CallStatus.values();
        }
        throw new IllegalArgumentException("Invalid input: " + enumString);
    }
}
