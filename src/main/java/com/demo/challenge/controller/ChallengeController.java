package com.demo.challenge.controller;

import com.demo.challenge.model.Response;
import com.demo.challenge.service.ChallengeServices;
import com.lob.api.ApiException;
import com.lob.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/address")
public class ChallengeController {

    @Value("${client.lob-java.api-key}")
    private String apiKey;

    private final ChallengeServices challengeServices;

    public ChallengeController(ChallengeServices challengeServices) {
        this.challengeServices = challengeServices;
    }

    @GetMapping("/autocomplete/{prefix}")
    public ResponseEntity<Response> ChallengeAutoComplete(@RequestParam String prefix,
                                                          @RequestParam(required = false) String city,
                                                          @RequestParam(required = false) String state,
                                                          @RequestParam(required = false) String zipcode) {


        Response response = new Response();
        UsAutocompletions usAutocompletion ;
        try {

            usAutocompletion = challengeServices.callApiLobAutoComplation(prefix,city,state,zipcode);

        } catch (ApiException e) {
            throw new RuntimeException(e);
        }

        response.setId(usAutocompletion.getId());
        response.setSuggestions(usAutocompletion.getSuggestions());
        response.setObject(Objects.requireNonNull(usAutocompletion.getObject()).toString());

        return ResponseEntity.ok(response);
    }

}
