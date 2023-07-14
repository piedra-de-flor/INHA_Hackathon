package com.example.INHA_Hackathon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirInfoApiResponseDto {
    @Data
    @NoArgsConstructor
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Body {
        private int numOfRows;
        private int pageNo;
        private int totalCount;
        public Items items;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Items {
        private Item item;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        private String dataTime;
        private String informCode;
        private String informOverall;
        private String informCause;
        private String informGrade;
        private String actionKnack;
        private String imageUrl1;
        private String imageUrl2;
        private String imageUrl3;
        private String imageUrl4;
        private String imageUrl5;
        private String imageUrl6;
        private String imageUrl7;
        private String imageUrl8;
        private String imageUrl9;
        private String informData;
    }

    @Data
    @NoArgsConstructor
    public static class response {
        public Header header;
        public Body body;

        public String getInformGrade() {
            return body.items.item.informGrade;
        }
    }
}
