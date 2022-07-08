package hashtable.hashmap.simple

fun main() {

    val set = SimpleHashMap(6)

    (0..200).forEach { set.put(it, 120) }

    println(set)

    set.put(1, 150)
    set.put(8, 69)
    set.remove(2)

    println()
    println(set)

    println(set.get(8))

}