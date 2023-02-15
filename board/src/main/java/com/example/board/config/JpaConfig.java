package com.example.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import java.util.Optional;
@EnableJpaAuditing
@Configuration
public class JpaConfig {
    //테이블에 레코드를 삽입할 때 누가 만들었는지에 대한 정보를 제공받기 위함
    //오디팅할 때 사람 이름 정보를 넣어주기 위함
    @Bean
    public AuditorAware<String> auditorAware(){
        //사람의 임의 정보를 넣어줌
        // 스프링 시큐리티로 인증 기능을 붙일 때 수정해야함
        return () -> Optional.of("uno");
    }
}
