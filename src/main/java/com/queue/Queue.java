package com.queue;

import com.queue.exception.EmptyQueueException;
import com.stack.exception.EmptyStackException;

public interface Queue<T> {
    public Queue<T> enQueue(T t);
    public Queue<T> deQueue() throws EmptyQueueException, EmptyStackException;
    public T head() throws EmptyQueueException, EmptyStackException;
    public boolean isEmpty();
}