package com.knd.test_nyton.configuration;

import com.knd.test_nyton.service.TradeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MOEXWebClientConfiguration {

@Bean
    public TradeService tradeService(){
    return new TradeService(WebClient.create("https://iss.moex.com"));
}
}
