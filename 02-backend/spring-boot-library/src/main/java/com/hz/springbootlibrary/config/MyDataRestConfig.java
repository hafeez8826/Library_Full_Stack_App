package com.hz.springbootlibrary.config;

import com.hz.springbootlibrary.entity.Book;
import com.hz.springbootlibrary.entity.Message;
import com.hz.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private String theAllowedOrigins = "http://localhost:3000";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration,
                                                     CorsRegistry cors){
        HttpMethod[] theUnsupportedMethods = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT
        };

        configuration.exposeIdsFor(Book.class);
        configuration.exposeIdsFor(Review.class);
        configuration.exposeIdsFor(Message.class);
        disableHttpMethods(Book.class, configuration, theUnsupportedMethods);
        disableHttpMethods(Review.class, configuration, theUnsupportedMethods);
        disableHttpMethods(Message.class, configuration, theUnsupportedMethods);
        
        /* Config CORS Mapping*/
        cors.addMapping(configuration.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
                                    HttpMethod[] theUnsupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }


}


