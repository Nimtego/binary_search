import binaryT.ThreadedBinarySearchTree
import javasrc.MainJ
import kotlinsrc.MainK
import java.util.*

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val jTimeSpent: Long
        val kTimeSpent: Long
        val jTimeStart = System.currentTimeMillis()
        MainK.main()
        jTimeSpent = System.currentTimeMillis() - jTimeStart

        val kTimeStart = System.currentTimeMillis()
        MainJ.main()
        kTimeSpent = System.currentTimeMillis() - kTimeStart

        println("Java - $jTimeSpent \nKotlin - $kTimeSpent")

        startBinaryThread()
    }

    private fun startBinaryThread() {
        val scan = Scanner(System.`in`)

        val tbst = ThreadedBinarySearchTree()
        println("Multi-threaded Binary Search Tree \n")
        var ch: Char

        do {
            println("\nThreaded Binary Search Tree Operations\n")
            println("1. insert ")
            println("2. search")
            println("3. clear")

            var ch = ""

            when (scan.nextInt()) {
                1 -> {
                    println("Enter integer element to insert")
                    while (true) {
                        try {
                            tbst.insert(scan.nextInt())
                        } catch (e: InputMismatchException) { break }
                    }

                }
                2 -> {
                    println("Enter integer element to search")
                    println("Search result : " + tbst.search(scan.nextInt()))
                }
                3 -> {
                    println("\nTree Cleared\n")
                    tbst.clear()
                }
                else -> println("Wrong Entry \n ")
            }

            print("\nTree = ")
            tbst.inOrder()
            println()

            println("\nDo you want to continue (Type y or n) \n")
            ch = scan.next()
        } while (ch != "n")
    }

}