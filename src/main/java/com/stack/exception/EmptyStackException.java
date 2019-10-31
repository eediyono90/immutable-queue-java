package com.stack.exception;

public final class EmptyStackException extends Exception {
    public EmptyStackException() {
		super("Stack is Empty!");
	}
}