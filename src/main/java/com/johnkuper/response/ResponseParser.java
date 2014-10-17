package com.johnkuper.response;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

public interface ResponseParser {

	// Parse json arrays
	<Model> List<Model> getMultiData(ClientResponse response, String dataName,
			Class<Model> modelType);

	// Parse single json object
	<Model> Model getSingleData(ClientResponse response, String dataName,
			Class<Model> modelType);

	// Parse response status
	String getResponseStatus(ClientResponse response);
}
