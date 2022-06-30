package queues.circularqueue

class CircularQueue(buffer: Int = 10) {

    private val space = Array(buffer) { 0 }

    private var head = -1
    private var tail = -1
    private var size = buffer

    fun enqueue(value: Int): Boolean {
        if (isFull()) return false

        if (isEmpty()) {
            head = 0
        }
        tail = (tail + 1) % size
        space[tail] = value
        return true
    }

    fun dequeue(): Boolean {
        if (isEmpty()) return false

        if (head == tail) {
            head = -1
            tail = -1
            return true
        }

        head = ++head % size
        return true
    }

    fun first(): Int {
        if (isEmpty()) return -1
        return space[head]

    }

    fun last(): Int {
        if (isEmpty()) return -1
        return space[tail]
    }

    fun isEmpty(): Boolean {
        return tail == -1
    }

    fun isFull(): Boolean {
        return (head + size - 1) % size == tail
    }

    fun print() {
        print("[ ")
        space.forEach {
            print("$it ")
        }
        println("]")
    }
}