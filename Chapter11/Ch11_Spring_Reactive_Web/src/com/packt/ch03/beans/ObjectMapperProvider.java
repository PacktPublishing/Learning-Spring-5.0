package com.packt.ch03.beans;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

@Produces(MediaType.APPLICATION_JSON)
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
	ObjectMapper mapper;

	public ObjectMapperProvider() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}
}