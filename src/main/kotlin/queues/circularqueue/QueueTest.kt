package queues.circularqueue

fun main() {

    val queue = CircularQueue(5)
    with(queue) {
        print()
        enqueue(1)
        enqueue(2)
        enqueue(3)
        enqueue(4)
        enqueue(5)
        print()
        enqueue(10)
        dequeue()
        enqueue(10)
        print()
        enqueue(20)
        dequeue()
        dequeue()
        enqueue(21)
        enqueue(22)
        print()
    }

}