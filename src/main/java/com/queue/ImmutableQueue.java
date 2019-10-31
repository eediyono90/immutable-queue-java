package com.queue;

import com.stack.Stack;
import com.stack.EmptyStack;
import com.queue.exception.EmptyQueueException;
import com.stack.exception.EmptyStackException;

public final class ImmutableQueue<T> implements Queue<T> {

    private final Stack<T> forwardStack;
    private final Stack<T> backwardStack;

    public ImmutableQueue(Stack<T> forwardStack, Stack<T> backwardStack) {
        this.forwardStack = forwardStack;
        this.backwardStack = backwardStack;
    }

    @Override
    public final Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(forwardStack, backwardStack.push(t));
    }

    @Override
    public final Queue<T> deQueue() throws EmptyQueueException, EmptyStackException {
        Stack<T> forward = this.forwardStack.pop();
        if(!forward.isEmpty()) {
            return new ImmutableQueue<T>(forward, this.backwardStack);
        } else {
            if(this.backwardStack.isEmpty()) {
                return EmptyQueue.getInstance();
            } else {
                return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwardStack), EmptyStack.getInstance());
            }
        }
    }
    
    @Override
    public T head() throws EmptyQueueException, EmptyStackException {
        return this.forwardStack.head();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static final Stack reverseStack(Stack stack) throws EmptyStackException {
        Stack reversedStack = EmptyStack.getInstance();
        for(Stack s = stack; !s.isEmpty(); s = s.pop()) {
            reversedStack = reversedStack.push(s.head());
        }
        return reversedStack;
    }

    public static final Queue getEmptyQueue() {
        return EmptyQueue.getInstance();
    }
}