package com.org.hms.apis.configurations;

import org.jboss.logging.MDC;

import io.jaegertracing.internal.JaegerSpan;
import io.jaegertracing.spi.Reporter;

public class TracingMDCReporter implements Reporter {

    public TracingMDCReporter() {
        // default constructor
    }

    @Override
    public void report(JaegerSpan span) {
        MDC.put("traceinfo", span);
    }

    @Override
    public void close() {
        // default close method
    }

}