package com.springboot.lionboot.hospital.readlineparser;

import com.springboot.lionboot.hospital.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext(){
        return new ReadLineContext<Hospital>(
                new HospitalParser()
        );

    }

}
