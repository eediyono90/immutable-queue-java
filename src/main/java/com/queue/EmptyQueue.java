package com.queue;

import com.queue.exception.EmptyQueueException;
import com.stack.ImmutableStack;

// Singleton Empty Queue
public final class EmptyQueue<T> implements Queue<T> {
    private final static EmptyQueue empty = new EmptyQueue();
    public final static EmptyQueue getInstance() {
        return empty;
    }

    @Override
    public final Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
    }

    @Override
    public final Queue<T> deQueue() throws EmptyQueueException {
        throw new EmptyQueueException();
    }

    @Override
    public final T head() throws EmptyQueueException {
        throw new EmptyQueueException();
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }
}