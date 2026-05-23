package com.incidents.config;

import io.micrometer.core.instrument.MeterRegistry;

import jakarta.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class MonitoringConfig {

    private final MeterRegistry meterRegistry;

    @PostConstruct
    public void init() {

        log.info(
                "Monitoring Enterprise Config Initialized"
        );

        meterRegistry.counter(
                "application.startup"
        ).increment();
    }
}