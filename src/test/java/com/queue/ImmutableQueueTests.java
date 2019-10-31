package com.queue;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.queue.exception.EmptyQueueException;
import com.stack.exception.EmptyStackException;

public class ImmutableQueueTests {
    @Test
    public void assertEmptyQueueIsNotNull() {
        assertNotNull(ImmutableQueue.getEmptyQueue());
    }

    @Test
    public void assertEnqueueEmptyQueueSuccess() throws EmptyQueueException, EmptyStackException {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue().enQueue(new Integer(1));
        assertEquals(queue.head(), new Integer(1));
    }

    @Test
    public void assertDequeueFromEmptyQueueToThrowEmptyQueueException() {
        assertThrows(EmptyQueueException.class, () -> {
            Queue<Integer> queue = ImmutableQueue.getEmptyQueue().deQueue();
        });
    }

    @Test
    public void assertHeadFromEmptyQueueToThrowEmptyQueueException() {
        assertThrows(EmptyQueueException.class, () -> {
            Queue<Integer> queue = ImmutableQueue.getEmptyQueue();
            queue.head();
        });
    }

    @Test
    public void assertIsEmptyFromEmptyQueueToReturnTrue() {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void assertIsEmptyFromNonEmptyQueueToReturnFalse() {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue();
        queue = queue.enQueue(new Integer(2));
        assertFalse(queue.isEmpty());
    }

    @Test
    public void assertEnqueueNonEmptyQueueSuccess() throws EmptyQueueException, EmptyStackException {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue().enQueue(new Integer(1));
        queue = queue.enQueue(new Integer(2));
        assertEquals(queue.head(), new Integer(1));
    }

    @Test
    public void assertDequeueNonEmptyQueueSuccess() throws EmptyQueueException, EmptyStackException {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue().enQueue(new Integer(1));
        queue = queue.enQueue(new Integer(2));
        queue = queue.deQueue();
        assertEquals(queue.head(), new Integer(2));
    }

    @Test
    public void assertAfterDequeueAllQueueIsEmptyReturnTrue() throws EmptyQueueException, EmptyStackException {
        Queue<Integer> queue = ImmutableQueue.getEmptyQueue().enQueue(new Integer(1));
        queue = queue.enQueue(new Integer(2));
        queue = queue.enQueue(new Integer(3));
        queue = queue.deQueue();
        queue = queue.deQueue();
        queue = queue.deQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void assertAfterDequeueAllQueueDequeueWillThrowEmptyQueueExeception() throws EmptyQueueException, EmptyStackException {
        assertThrows(EmptyQueueException.class, () -> {
            Queue<Integer> queue = ImmutableQueue.getEmptyQueue().enQueue(new Integer(1));
            queue = queue.enQueue(new Integer(2));
            queue = queue.enQueue(new Integer(3));
            queue = queue.deQueue();
            queue = queue.deQueue();
            queue = queue.deQueue();
            queue = queue.deQueue();
        });
    }
}