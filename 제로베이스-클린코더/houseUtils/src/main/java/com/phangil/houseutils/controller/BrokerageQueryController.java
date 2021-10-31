package com.phangil.houseutils.controller;

import com.phangil.houseutils.constants.ActionType;
import com.phangil.houseutils.policy.BrokeragePolicy;
import com.phangil.houseutils.policy.BrokeragePolicyFactory;
import com.phangil.houseutils.policy.PurchaseBrokeragePolicy;
import com.phangil.houseutils.policy.RentBrokeragePolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {

        // TODO: 중개수수료 계산하는 로직
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

}
