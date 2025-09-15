package org.basic.collection;

public class MyStack {
    private Object[] myStack; // Object로 수정
    private int capacity;     // 스택 용량
    private int ptr;          // 스택 포인터

    MyStack(int maxlen) {
        capacity = maxlen;
        ptr = 0;
        try {
            myStack = new Object[capacity];   // 본체 배열 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없음
            capacity = 0;
            myStack = null;
        }
    }

    public void push(Object obj) throws StackOverflowError {
        if (ptr >= capacity) {
            throw new StackOverflowError("스택이 가득 찼습니다.");
        }
        myStack[ptr++] = obj;
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return myStack[--ptr];
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public static void main(String[] args) {
        MyStack myStack1 = new MyStack(10);

        myStack1.push(1);
        myStack1.push("나니가스키");

        MyGeneric myGeneric = new MyGeneric();
        myStack1.push(myGeneric);

        System.out.println("isFull? " + myStack1.isFull());
        System.out.println("pop: " + myStack1.pop());
        System.out.println("pop: " + myStack1.pop());
        System.out.println("isEmpty? " + myStack1.isEmpty());
        System.out.println("isFull? " + myStack1.isFull());
        System.out.println("pop: " + myStack1.pop());
    }
}
