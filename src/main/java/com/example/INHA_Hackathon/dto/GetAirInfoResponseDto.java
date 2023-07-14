package com.example.INHA_Hackathon.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetAirInfoResponseDto {
    private final int NUMBER_FOR_LAST_INDEX_OF_ARRAY = 1;
    private String informGrade;

    public GetAirInfoResponseDto(AirInfoApiResponseDto.response airInfoApiResponse) {
        this.informGrade = filteringData(airInfoApiResponse.getInformGrade());
    }

    public GetAirInfoResponseDto(String errorMassage) {
        this.informGrade = errorMassage;
    }

    private String filteringData(String airInfo) {
        String[] localInfo = airInfo.split(",");

        return localInfo[localInfo.length - NUMBER_FOR_LAST_INDEX_OF_ARRAY];
    }
}
