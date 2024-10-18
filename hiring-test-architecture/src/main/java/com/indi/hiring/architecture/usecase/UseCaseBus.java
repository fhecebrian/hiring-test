package com.indi.hiring.architecture.usecase;

import org.springframework.stereotype.Service;

@Service
public class UseCaseBus {

	public <R> R invoke(UseCase<R> useCase) {
		return useCase.execute();
	}
}
