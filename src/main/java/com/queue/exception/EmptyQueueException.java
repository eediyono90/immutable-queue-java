package com.queue.exception;

public final class EmptyQueueException extends Exception {
    public EmptyQueueException() {
		super("Queue is Empty!");
	}
}