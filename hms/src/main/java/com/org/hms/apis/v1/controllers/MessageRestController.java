package com.org.hms.apis.v1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/config/")
public class MessageRestController {

	@Value("${server.url:Unable to connect to config server}")
	private String url;

	@RequestMapping("/server/url")
	String getMsg() {
		return this.url;
	}

}
