package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Document_indexer {

    public void Indexer(HashMap<String, Set<Integer>> Document_map) throws JsonProcessingException {
        HashMap<String, Set<Integer>> mape = new HashMap<>();
        HashMap<String, Set<Integer>> mape2 = new HashMap<>();
        Set<Integer> list = new HashSet<>();
        list.add(1);
        list.add(2);

        mape.put("hola",list);
        mape2.put("adios",list);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(mape);

        JSONObject jso = new JSONObject();
        jso.append("TRYING",mape);
        jso.append("TRYING",mape2);


        System.out.println(jso);


    }

}
