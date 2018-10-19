import kotlinsrc.MainK
import javasrc.MainJ

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val jTimeSpent : Long
        val kTimeSpent : Long

        val jTimeStart = System.currentTimeMillis()
        MainK.main()
        jTimeSpent = System.currentTimeMillis() - jTimeStart

        val kTimeStart = System.currentTimeMillis()
        MainJ.main()
        kTimeSpent = System.currentTimeMillis() - kTimeStart

        print("Java - $jTimeSpent \nKotlin - $kTimeSpent")
    }
}