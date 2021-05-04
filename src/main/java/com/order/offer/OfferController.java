package com.order.offer;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {
    @Autowired
    private KieSession session;

    @PostMapping("/order")
    public Cart orderNow(@RequestBody Cart order) {
        session.insert(order);
        session.fireAllRules();
        return order;
    }

}