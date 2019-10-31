package com.stack;

import com.stack.exception.EmptyStackException;

public interface Stack<T> {
    public Stack<T> push(T t);
    public Stack<T> pop() throws EmptyStackException;
    public T head() throws EmptyStackException;
    public boolean isEmpty();
}