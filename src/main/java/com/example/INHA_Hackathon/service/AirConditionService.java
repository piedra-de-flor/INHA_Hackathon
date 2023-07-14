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
    private final OpenFeignClient openFeignClient;

    @Transactional
    public GetAirInfoResponseDto getAirInfo() throws IOException {
        GetAirInfoResponseDto airInfoApiResponseDto;
        LocalDate today = LocalDate.now();
        String encodedDate = URLDecoder.decode("2023-07-13", StandardCharsets.UTF_8);
            try {
                airInfoApiResponseDto = new GetAirInfoResponseDto(getAirInfo(encodedDate));
            }
            catch (NullPointerException exception) {
                airInfoApiResponseDto = new GetAirInfoResponseDto("해당 날짜의 데이터는 조회가 불가능 합니다");
            }
        return airInfoApiResponseDto;
        }

    public AirInfoApiResponseDto.response getAirInfo(String searchDate) throws IOException {
        String encodedServiceKey = URLDecoder.decode("u2XnRNRAQIy5gg%2BJh6TXfRoDnS3%2BK8UsIvP5B0jQtaNIwFsxzlOhVhagS9bNVL%2Fw848PaSG7D0L2egFgJDGXzw%3D%3D", StandardCharsets.UTF_8);
        String xmlResponse = openFeignClient.getAirInfo(searchDate, encodedServiceKey);
        XmlMapper xmlMapper = new XmlMapper();

        AirInfoApiResponseDto.response response = xmlMapper.readValue(xmlResponse, AirInfoApiResponseDto.response.class);
        return response;
    }
}
