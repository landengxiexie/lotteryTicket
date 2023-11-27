package com.yhbl.ticket.controller;

/**
 * @ClassName: MasterController
 * @Description:
 * @Author: savn
 * @Date: 2023/11/23 22:44
 */

import java.util.Map;

import com.yhbl.ticket.utils.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/pub/ticket"})
public class MasterController {

    @GetMapping({"/getTicket"})
    public Object ticket(Integer lts, Integer tbts) {
	if(lts>100||tbts>100){
		return "输入注数应≤100";
	}
        Map<Object, Object> multiple = Ticket.multiple(lts, tbts);
        if (multiple==null){
            return "null";
        }
        return multiple;
    }
}

