package com.indi.hiring.architecture.context.holder;

import org.springframework.stereotype.Service;

import static org.mockito.Mockito.mock;

@Service
public class TestContextHolder implements ContextHolder {
	@Override
	public <T> T locate(Class<T> clazz) {
		return mock(clazz);
	}
}
