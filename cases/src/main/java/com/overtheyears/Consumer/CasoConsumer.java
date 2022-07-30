package com.overtheyears.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.overtheyears.Service.HumanCaseService;
import com.overtheyears.cases.DTO.ConsumerDTO;
import com.overtheyears.cases.entity.HumanCase;

@Component
public class CasoConsumer {
    
    @Autowired
    private HumanCaseService humanCaseService;

    @RabbitListener(queues = "crud.overtheyears.cases")
    public void consumer(@Payload HumanCase human) {
        try {
            salvarCaso(human);
            System.out.println("Caso registrado com sucesso");
        } catch (

        Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void salvarCaso(HumanCase human) {

        humanCaseService.save(human);
    }
}
