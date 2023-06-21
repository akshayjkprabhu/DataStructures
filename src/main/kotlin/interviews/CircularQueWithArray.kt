package interviews

import java.lang.IllegalStateException

fun main() {

    val queue = CircularQueue(5)
    while (true) {

        when (val input = readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Enqueue with")
                readlnOrNull()?.toIntOrNull()?.let {
                    queue.add(it)
                    queue.print()
                }
            }

            2 -> {
                queue.remove()
                queue.print()
            }
        }
    }


}

class CircularQueue(private val capacity: Int) {

    private val data: Array<Int> = Array(capacity) { 0 }

    private var front = -1
    private var rear = -1


    fun add(e: Int) {
        // Initial condition

        if (isFull()) {
            throw IllegalStateException("Queue is Full. Can not add any new element")
        }
        if (front == -1 && rear == -1) {
            front = 0
        }
        rear = (rear + 1) % capacity
        data[rear] = e
    }

    fun remove(): Int {
        if (isEmpty()) {
            throw IllegalStateException("Can not remove item from empty queue")
        }

        val element = data[front]

        if (front == rear) {
            // One element is present
            front = -1
            rear = -1
        } else {
            front = (front + 1) % capacity
        }
        return element
    }

    private fun isEmpty(): Boolean {
        return front == rear && front == -1
    }

    private fun isFull(): Boolean {
        return (rear + 1) % capacity == front
    }


    fun print() {
        if (isEmpty()) {
            println("Empty Queue")
            return
        }
        var index = front

        while (if (front <= rear)
                index < rear
            else (index in front until capacity) || (index in 0 until rear)
        ) {
            print(data[index])
            print(", ")
            index = (index + 1) % capacity
        }

        print(data[rear])

        println()
        println("Front : $front, rear : $rear")
    }

}