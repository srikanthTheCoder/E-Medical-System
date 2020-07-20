package com.org.hms.apis.configurations;

import java.util.Collection;

import io.jaegertracing.spi.Reporter;
import io.opentracing.contrib.java.spring.jaeger.starter.ReporterAppender;

public class JaegerReportAppender implements ReporterAppender {

  public JaegerReportAppender() {
    // default constructor
  }

  @Override
  public void append(Collection<Reporter> reporters) {
    reporters.add(new TracingMDCReporter());
  }

}