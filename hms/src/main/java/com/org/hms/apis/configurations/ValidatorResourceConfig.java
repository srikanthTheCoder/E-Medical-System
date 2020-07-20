package com.org.hms.apis.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorResourceConfig {

    @Value("${validations.message.location:validations/message}")
    private String basename;

    @Bean(name = "validationResource")
    public MessageSource validationResource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:" + basename);
        messageSource.setDefaultLocale(LocaleContextHolder.getLocale());
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600); // Refresh cache once per hour.
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(validationResource());
        return bean;
    }
}