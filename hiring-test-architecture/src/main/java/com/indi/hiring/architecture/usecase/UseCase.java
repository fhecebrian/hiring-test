package com.indi.hiring.architecture.usecase;

public abstract class UseCase<T> {

	protected abstract T run();

	protected T execute() {
		return run();
	}

	protected <R> R runInternal(UseCase<R> otherUsecase) {
		return otherUsecase.run();
	}
}
