package com.stack;

import com.stack.exception.EmptyStackException;

public final class ImmutableStack<T> implements Stack<T> {
    private final T head;
    private final Stack<T> tail;
    public ImmutableStack(T head, Stack<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> pop() throws EmptyStackException {
        return tail;
    }

    @Override
    public T head() throws EmptyStackException {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static final Stack getEmptyStack() {
        return EmptyStack.getInstance();
    }
}