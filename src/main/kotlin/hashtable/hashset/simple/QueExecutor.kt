package hashtable.hashset.simple

fun main() {

    val set = SimpleHashSet(6)

    (0..200).forEach { set.add(it) }

    println(set)

}