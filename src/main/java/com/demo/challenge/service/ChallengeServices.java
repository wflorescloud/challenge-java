package com.demo.challenge.service;

import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.HttpBasicAuth;
import com.lob.api.client.UsAutocompletionsApi;
import com.lob.model.UsAutocompletions;
import com.lob.model.UsAutocompletionsWritable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServices {

    @Value("${client.lob-java.api-key}")
    private String apiKey;

    public UsAutocompletions callApiLobAutoComplation(String addressPrefix, String city, String state, String zipcode) throws ApiException {

        ApiClient lobClient = Configuration.getDefaultApiClient();
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) lobClient.getAuthentication("basicAuth");
        basicAuth.setUsername(apiKey);
        UsAutocompletionsApi apiInstance = new UsAutocompletionsApi(lobClient);
        UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable();
        autoCompletionWritable.setAddressPrefix(addressPrefix);

        if (city != null) {
            autoCompletionWritable.setCity(city);
        }

        if ( state != null) {
            autoCompletionWritable.setState(state);
        }

        if (zipcode != null) {
            autoCompletionWritable.setZipCode(zipcode);
        }

        System.err.println("object autoCompletionWritable: " + autoCompletionWritable.toString());



        return apiInstance.autocomplete(autoCompletionWritable);

    }

}
