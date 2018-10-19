package kotlinsrc
import java.math.BigDecimal
import java.util.ArrayList
import java.util.function.Consumer

class BinarySearchK<T : Number> : SearchK<T> {


    private var list: MutableList<T>
    private var isSort: Boolean = false

    init {
        this.list = ArrayList()
    }


    override fun itemExists(item: T): Boolean {
        return list.contains(item)
    }

    override fun sort(set: MutableList<T>): List<T> {
        this.list = set
        return sort()
    }


    override fun sort(): List<T> {
        val start = 0
        val end = list.size - 1
        sort(start, end)
        isSort = true
        return list
    }

    private fun sort(start: Int, end: Int) {

        if (start >= end)
            return
        var i = start
        var j = end
        var cur = i - (i - j) / 2

        while (i < j) {
            var bdItemI = BigDecimal(list[i].toString())
            var bdItemCur = BigDecimal(list[cur].toString())
            var bdItemJ = BigDecimal(list[j].toString())
            while (i < cur && bdItemI <= bdItemCur) {
                i++
                bdItemI = BigDecimal(list[i].toString())
                bdItemCur = BigDecimal(list[cur].toString())
            }
            while (j > cur && bdItemCur <= bdItemJ) {
                j--
                bdItemCur = BigDecimal(list[cur].toString())
                bdItemJ = BigDecimal(list[j].toString())
            }
            if (i <= j) {
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp

                if (i == cur)
                    cur = j
                else if (j == cur)
                    cur = i
            }
        }
        sort(start, cur)
        sort(cur + 1, end)
    }

    override fun putItem(item: T) {
        if (isSort) {
            val bdItem = BigDecimal(item.toString())
            for (i in list.indices) {
                val bdList = BigDecimal(list[i].toString())
                if (bdItem <= bdList) {
                    list.add(i, item)
                    break
                }
                if (i + 1 == list.size && bdItem > bdList) {
                    list.add(i + 1, item)
                }
            }
        } else
            list.add(item)
    }

    override fun binary(number: T): Int {
        return rank(BigDecimal(number.toString()), list, 0, list.size - 1) + 1
    }

    override fun toString(): String {
        val sb = StringBuilder()
        list.forEach { sb.append(it) }
        return sb.toString()
    }

    private fun rank(value: BigDecimal, arr: List<T>?, lo: Int, hi: Int): Int {
        if (lo > hi) return -1
        val mid = lo + (hi - lo) / 2
        val bgMid = BigDecimal(arr!![mid].toString())
        return when {
            value < bgMid -> {
                visual(mid)
                rank(value, arr, lo, mid - 1)
            }
            value > bgMid -> {
                visual(mid)
                rank(value, arr, mid + 1, hi)
            }
            else -> {
                visual(mid)
                mid
            }
        }
    }

    private fun visual(mid: Int) {
        for (i in list.indices) {
            if (mid == i) {
                print(" [${list[i]}] ")
                continue
            }
            print("${list[i]} ")
        }
        println()

    }
}