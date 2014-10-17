package com.johnkuper.response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.ClientResponse;

public class ResponseParserImpl implements ResponseParser {

	final static Logger logger = LoggerFactory.getLogger("JohnKuper");
	ObjectMapper mapper;

	public ResponseParserImpl() {
		mapper = new ObjectMapper();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <Model> Model getSingleData(ClientResponse response,
			String dataName, Class<Model> modelType) {

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		logger.debug("--- Output from Server --- \n{}", output);

		Map<String, Object> map = new HashMap<>();
		Model model = null;
		try {
			map = mapper.readValue(output, Map.class);
			Object modelInfo = map.get(dataName);
			String modelJson = mapper.writeValueAsString(modelInfo);
			model = mapper.readValue(modelJson, modelType);
			logger.debug("Object from json: {}", model);
		} catch (IOException e) {
			logger.error("IOException during 'getSingleData'", e);
		}

		return model;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <Model> List<Model> getMultiData(ClientResponse response,
			String dataName, Class<Model> modelType) {

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);

		logger.debug("--- Output from Server --- \n{}", output);

		Map<String, Object> map = new HashMap<>();
		List<Model> models = null;
		try {
			map = mapper.readValue(output, Map.class);
			Object modelInfo = map.get(dataName);
			String modelJson = mapper.writeValueAsString(modelInfo);
			logger.debug("JSON from multi data: {}", modelJson);
			final CollectionType javaType = mapper.getTypeFactory()
					.constructCollectionType(List.class, modelType);
			models = mapper.readValue(modelJson, javaType);
			logger.debug("List of objects from json: {}", models);
		} catch (IOException e) {
			logger.error("IOException during 'getSingleData'", e);
		}

		return models;
	}

	@Override
	public String getResponseStatus(ClientResponse response) {

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);
		return output;
	}

}
