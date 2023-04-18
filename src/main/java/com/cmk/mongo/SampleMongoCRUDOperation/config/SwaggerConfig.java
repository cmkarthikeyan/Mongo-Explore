package com.cmk.mongo.SampleMongoCRUDOperation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    /*@Value("${dev-server-url}")
    private String devServerUri;

    /*@Value("${local-server-url}")
    private String localServerUri;

    @Value("${uat3-server-url}")
    private String uat3ServerUri;*/

    @Value("${local-server-url}")
    private String localServerUri;

    @Bean
    public OpenAPI customAPi() {

        Server localServer = new Server();
        localServer.setDescription("Local");
        localServer.setUrl(localServerUri);

        Server devServer = new Server();
        devServer.setDescription("DEV");
        devServer.setUrl(localServerUri);

        Server uat3Server = new Server();
        uat3Server.setDescription("UAT3");
        uat3Server.setUrl(localServerUri);

       //need to add prod servers

      return new OpenAPI().info(new Info()
       // .title("CMK-MongoDb-Complete-Example")).servers(Arrays.asList(localServer,devServer,uat3Server));
              .title("CMK-MongoDb-Complete-Example")).servers(List.of(localServer, devServer, uat3Server));
    }
}
