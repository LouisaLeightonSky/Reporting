package com.bskyb.gdm.batch.reporting.business;

import com.bskyb.gdm.batch.reporting.model.Action;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ActionDeserializer extends JsonDeserializer<Action> {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Action deserialize(JsonParser jp, DeserializationContext ctx)
            throws IOException {
        try {
            objectMapper=new ObjectMapper();
            Action  action=objectMapper.readValue(jp,Action.class);
                  //  =new Action();
           /* if(node.has("kind"))
            {
                action.setKind(node.get("Kind"));
            }else if(node.has("Field")){
                action.setField(node.get("Kind"));
            }else{
                Map<String, ActionDetail> actionDetails=node
            }*/
            return action;

        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}