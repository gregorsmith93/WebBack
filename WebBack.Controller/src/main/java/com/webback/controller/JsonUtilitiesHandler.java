package com.webback.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtilitiesHandler implements JsonUtilities {

	private static final Logger LOG = LogManager.getLogger(JsonUtilitiesHandler.class);

	private final ObjectMapper mapper;

	private JsonUtilitiesHandler() {
		this.mapper = new ObjectMapper();
	}

	@Override
	public String convertToJsonString(final Object content) {

		LOG.debug("Converting object of type: {} to json string.", content.getClass().getSimpleName());

		String jsonString = "";

		try {
			jsonString = mapper.writeValueAsString(content);
		} catch (final JsonProcessingException e) {
			LOG.warn("Couldn't convert object to json string, exception was: {}", e);
			jsonString = "";
		}

		LOG.debug("Converted object to json string: {}", jsonString);

		return jsonString;
	}
}
