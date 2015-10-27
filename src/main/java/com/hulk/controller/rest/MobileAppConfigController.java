package com.hulk.controller.rest;

import com.google.common.collect.Lists;
import com.hulk.enums.CallStatus;
import com.hulk.enums.IndianCity;
import com.hulk.enums.IndianState;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vijayvar on 10/28/15.
 */
@RestController
@RequestMapping("/mobileAppConfig")
public class MobileAppConfigController {

    @RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCities() {
        return Arrays.stream(IndianCity.values())
                .map(IndianCity::toString)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/getAllStates", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllStates() {
        return Arrays.stream(IndianState.values())
                .map(IndianState::toString)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/getAllCallStatuses", method = RequestMethod.GET)
    public @ResponseBody List<String> getAllCallStatuses() {
        return Arrays.stream(CallStatus.values())
                .map(CallStatus::toString)
                .collect(Collectors.toList());
    }
}
