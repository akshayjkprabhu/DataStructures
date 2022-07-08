package hashtable.hashmap.simple

class SimpleHashMap(private val bucketSize: Int = 10) {

    private val buckets = Array(bucketSize) { ArrayList<Data>() }

    data class Data(val key: Int, var value: Int) {
        override fun toString(): String {
            return "($key, $value)"
        }
    }

    fun put(key: Int, value: Int) {
        val index = bucketIndexOf(key)
        val list = buckets[index]
        list.find { it.key == key }?.let {
            it.value = value
        } ?: run {
            list.add(Data(key, value))
        }
    }

    fun get(key: Int): Int {
        val index = bucketIndexOf(key)
        val list = buckets[index]
        return list.find { it.key == key }?.value ?: -1
    }

    fun remove(key: Int) {
        val index = bucketIndexOf(key)
        val list = buckets[index]
        list.remove(list.find { it.key == key })
    }

    private fun bucketIndexOf(key: Int): Int {
        return key % bucketSize
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