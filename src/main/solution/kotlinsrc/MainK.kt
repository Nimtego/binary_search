package kotlinsrc

import java.util.Random

class MainK {
    companion object {
        fun main() {
            val r = Random()
            val integerSearch = BinarySearchK<Int>()
            for (i in 0..29) {
                integerSearch.putItem(r.nextInt(100))
            }
            println(integerSearch)
            integerSearch.sort()
            println(integerSearch)
            for (i in 0..29) {
                val number = r.nextInt(100)
                println("${integerSearch.binary(number)} search  $number")
            }


            val integerSearchFloat = BinarySearchK<Float>()
            val min = 1f
            val max = 10f
            for (i in 0..29) {
                integerSearchFloat.putItem(min + r.nextFloat() * (max - min))
            }
            println(integerSearchFloat)
            integerSearchFloat.sort()
            println(integerSearchFloat)
            for (i in 0..29) {
                val number = min + r.nextFloat() * (max - min)
                println("${integerSearchFloat.binary(number)} search -  $number")
            }
        }
    }
}