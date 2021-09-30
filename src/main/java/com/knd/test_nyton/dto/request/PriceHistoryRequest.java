package com.knd.test_nyton.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PriceHistoryRequest {
    private String ticker;
    private LocalDate from;
    private LocalDate till;
}
