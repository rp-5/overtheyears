package com.overtheyears.Consumer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.overtheyears.Service.HumanCaseService;
import com.overtheyears.cases.entity.HumanCase;

@Component
public class CasoConsumer {

    @Autowired
    private HumanCaseService humanCaseService;

    @RabbitListener(queues = "crud.overtheyears.cases")
    public void consumer(@Payload String caso) {
        try {
            JSONObject json = new JSONObject(caso);
            String name = json.getString("name");
            int age = json.getInt("age");
            String adress = json.getString("adress");
            String complement = json.getString("complement");
            String gravity = json.getString("gravity");
            String status = json.getString("status");
            boolean febre = json.getBoolean("febre");
            boolean manchas = json.getBoolean("dorCabeca");
            boolean dorCabeca = json.getBoolean("dorCabeca");
            boolean nausea = json.getBoolean("nausea");
            boolean dorOlhos = json.getBoolean("dorOlhos");
            boolean dorCorpo = json.getBoolean("dorCorpo");
            boolean cansaco = json.getBoolean("cansaco");
            HumanCase human = new HumanCase(
            name,
            age,
            adress,
            complement,
            gravity,
            status,
            febre,
            manchas,
            dorCabeca,
            nausea,
            dorOlhos,
            dorCorpo,
            cansaco
            );
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
