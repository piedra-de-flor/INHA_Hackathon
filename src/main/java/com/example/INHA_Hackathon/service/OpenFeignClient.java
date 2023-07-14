package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.configuration.OpenFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "searchAir" , url = "http://api.odcloud.kr", configuration = OpenFeignConfig.class)
public interface OpenFeignClient {
    @GetMapping(value = "/api/MinuDustFrcstDspthSvrc/v1/getMinuDustFrcstDspth")
    String getAirInfo( @RequestParam("searchDate") String searchDate, @RequestParam("serviceKey") String serviceKey);
}