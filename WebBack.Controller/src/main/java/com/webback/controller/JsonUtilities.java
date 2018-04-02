package com.webback.controller;

import org.springframework.stereotype.Component;

@Component
public interface JsonUtilities {

	String convertToJsonString(Object content);
}
