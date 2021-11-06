package com.phangil.houseutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author triple
 *
 * 서비스 헬스 체크를 조회하는 컨트롤러
 */
@RestController
public class HealthCheckController {

    @GetMapping("/api/ping")
    public String ping() {
        return "ok";
    }

}
