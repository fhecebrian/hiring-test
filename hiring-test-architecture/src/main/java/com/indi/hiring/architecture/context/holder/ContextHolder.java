package com.indi.hiring.architecture.context.holder;

public interface ContextHolder {

	<T> T locate(Class<T> clazz);
}
