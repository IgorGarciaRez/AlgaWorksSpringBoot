package com.algaworks.algamoneyapi.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {

    private final Seguranca seguranca = new Seguranca();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    @Getter
    @Setter
    public static class Seguranca{
        private boolean enableHttps;
    }

}
