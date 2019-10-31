package com.stack;

import com.stack.exception.EmptyStackException;

// Singleton EmptyStack

public final class EmptyStack<T> implements Stack<T> {
    private final static EmptyStack empty = new EmptyStack();
    public final static EmptyStack getInstance() {
        return empty;
    }
    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> pop() throws EmptyStackException {
        throw new EmptyStackException();
    };

    @Override
    public T head() throws EmptyStackException {
        throw new EmptyStackException();
    };
    
    @Override
    public boolean isEmpty() {
        return true;
    }
}