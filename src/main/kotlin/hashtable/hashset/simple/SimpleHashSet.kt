package hashtable.hashset.simple

/**
 * 0 <= key <= 10^6
 * At most 10^4 calls will be made to add, remove, and contains.
 */
class SimpleHashSet(private val bucketSize: Int = 10) {
    // Set => unique elements -> can have till 10^6 elements -> space for 10^6 + 1 elements
    // Searching 10^6 indices is lengthy
    // Divide into buckets 10^3 * 10*3
    // buckets is a Array -> and accessing is done via hash indices (Does not require search)
    // Searching only required in each bucket, which can be of 10^3 + 1 in size in worst case

    private val buckets = Array(bucketSize) { ArrayList<Int>() }

    fun add(element: Int) {
        if (contains(element)) return
        val index = bucketIndexOf(element)
        val bucket = buckets[index]
        bucket.add(element)
    }

    fun contains(element: Int): Boolean {
        val index = bucketIndexOf(element)
        val bucket = buckets[index]
        return bucket.contains(element)
    }

    fun remove(element: Int) {
        if (contains(element)) {
            val index = bucketIndexOf(element)
            buckets[index].remove(element)
        }
    }

    private fun bucketIndexOf(element: Int): Int {
        return element % bucketSize
    }

    override fun toString(): String {
        return StringBuilder().apply {
            buckets.forEachIndexed { i, b ->
                append("\n").append(i).append(" : ")
                b.forEach {
                    append(it).append(" ")
                }
            }
        }.toString()
    }
}