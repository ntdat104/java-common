package com.tiendat.algorithms.datastructures.queue;

public class IntQueue implements Queue<Integer> {
    private int[] data;
    private int front, end;
    private int size;

    // maxSize is the maximum number of items
    // that can be in the queue at any given time
    public IntQueue(int maxSize) {
        front = end = size = 0;
        data = new int[maxSize];
    }

    // Return true/false on whether the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the number of elements inside the queue
    public int size() {
        return size;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        front = front % data.length;
        return data[front];
    }

    public boolean isFull() {
        return size == data.length;
    }

    // Add an element to the queue
    @Override
    public void offer(Integer value) {
        if (isFull()) {
            throw new RuntimeException("Queue too small!");
        }
        data[end++] = value;
        size++;
        end = end % data.length;
    }

    // Make sure you check is the queue is not empty before calling poll!
    @Override
    public Integer poll() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        size--;
        front = front % data.length;
        return data[front++];
    }
}
