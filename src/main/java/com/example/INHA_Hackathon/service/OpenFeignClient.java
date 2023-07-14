package com.example.INHA_Hackathon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "searchAir" , url = "http://api.odcloud.kr", configuration = config.class)
public interface OpenFeignClient {
    @GetMapping(value = "/api/MinuDustFrcstDspthSvrc/v1/getMinuDustFrcstDspth")
    String getAirInfo( @RequestParam("searchDate") String searchDate, @RequestParam("serviceKey") String serviceKey);
}
//https://api.odcloud.kr/api/MinuDustFrcstDspthSvrc/v1/getMinuDustFrcstDspth?searchDate=2023-07-11&serviceKey=u2XnRNRAQIy5gg%2BJh6TXfRoDnS3%2BK8UsIvP5B0jQtaNIwFsxzlOhVhagS9bNVL%2Fw848PaSG7D0L2egFgJDGXzw%3D%3D