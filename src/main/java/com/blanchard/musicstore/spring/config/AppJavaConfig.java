package com.blanchard.musicstore.spring.config;

import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import com.blanchard.musicstore.view.MainViewController;

@Configuration
public class AppJavaConfig
{
    @Autowired SpringFXMLLoader springFXMLLoader;

    @Bean
    @Lazy(value = true)
    public MainViewController mainViewController(Stage stage)
    {
        return new MainViewController(springFXMLLoader, stage);
    }
}
