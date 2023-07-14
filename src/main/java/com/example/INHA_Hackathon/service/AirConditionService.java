package com.example.INHA_Hackathon.service;

import com.example.INHA_Hackathon.dto.AirInfoApiResponseDto;
import com.example.INHA_Hackathon.dto.GetAirInfoResponseDto;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class AirConditionService {
    private final String SERVICE_KEY = "u2XnRNRAQIy5gg%2BJh6TXfRoDnS3%2BK8UsIvP5B0jQtaNIwFsxzlOhVhagS9bNVL%2Fw848PaSG7D0L2egFgJDGXzw%3D%3D";
    private final LocalDate today = LocalDate.now();
    private final OpenFeignClient openFeignClient;

    @Transactional
    public GetAirInfoResponseDto getAirInfo() throws IOException {
        String encodedDate = URLDecoder.decode(String.valueOf(today), StandardCharsets.UTF_8);

            try {
                return new GetAirInfoResponseDto(getAirInfo(encodedDate));
            }
            catch (NullPointerException exception) {
                return new GetAirInfoResponseDto("해당 날짜의 데이터는 조회가 불가능 합니다");
            }
        }

    public AirInfoApiResponseDto.response getAirInfo(String searchDate) throws IOException {
        String encodedServiceKey = URLDecoder.decode(SERVICE_KEY, StandardCharsets.UTF_8);
        String xmlResponse = openFeignClient.getAirInfo(searchDate, encodedServiceKey);
        XmlMapper xmlMapper = new XmlMapper();

        return xmlMapper.readValue(xmlResponse, AirInfoApiResponseDto.response.class);
    }
}
