# Simple Immutable Queue implementation with java

This is repository contains sample code for simple Immutable Queue using java along with the unit test

To execute the unit test simply run: `./bin/setup` or `./gradlew test`

## Implementation

This `ImmutableQueue` is implemented by using 2 `ImmutableStack` : 
1. forward `ImmutableStack`
2. backward `ImmutableStack`

### Immutable Stack
`ImmutableStack` is implemented using recursive approach. Please find below illustration on how it works:

| Flow                       | Stack                     |
| -------------------------- | ------------------------- |
| Initialize Empty Stack     | EmptyStack                |
| Push(1)                    | (1, EmptyStack)           |
| Push(2)                    | (2, (1, EmptyStack))      |
| Push(3)                    | (3, (2, (1, EmptyStack))) |
| Pop()                      | (2, (1, EmptyStack))      |

### Immutable Queue
Implementation of the `ImmutableQueue` is by combining 2 `ImmutableStack` namely forward and backward. 
After deQueue:
1. if the forward stack is not empty then we will just return current `ImmutableQueue`
2. if the forward stack is empty, check the backward stack :
    1. if the backward stack is empty, it means the queue is empty
    2. if the backward stack is not empty, initialize forward stack with reverse value of backward stack and empty backward stack
Please find below illustration on how it works:


| Flow                       | Forward Stack             | Backward Stack           | 
| -------------------------- | ------------------------- |--------------------------|
| Initialize Empty Queue     |                           |                          |
| enQueue(1)                 | (1, EmptyStack)           | (EmptyStack)             |
| enQueue(2)                 | (1, EmptyStack)           | (2, EmptyStack)          |
| enQueue(3)                 | (1, EmptyStack)           | (3, (2, EmptyStack))     |
| deQueue()                  | (3, EmptyStack)           | (EmptyStack)             |
| deQueue()                  |                           |                          |
