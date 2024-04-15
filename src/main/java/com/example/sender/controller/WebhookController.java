package com.example.sender.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



@RestController
public class WebhookController {

    private WebClient webClient;
    
    public WebhookController(WebClient.Builder wBuilder){
        this.webClient = wBuilder.baseUrl("https://api.ap-southeast-a.apiconnect.ibmappdomain.cloud/api-connect-2f/sandbox/Webhook").build();
    }
    @PostMapping("/send-webhook")
    public Mono<String> sendWebhook() {
        //String ibmId = "dd655f1cd3742ddee5b33fac7975d791";
        return this.webClient.post()
                .uri("/Person")
                .contentType(MediaType.APPLICATION_JSON)
                .header("X-IBM-Client-Id", "dd655f1cd3742ddee5b33fac7975d791")
                .bodyValue("{\"Id\": 2.82248163,\n" +
                            "\"Name\": \"Pauline Caldwell\",\n" +
                            "\"Age\": \"53\",\n" +
                            "\"Gender\": \"Male\"\n" +
                            "}")
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> System.out.println("Webhook sent successfully: " + response))
                .doOnError(error -> System.out.println("Error sending webhook: " + error.getMessage()));
    }
}
