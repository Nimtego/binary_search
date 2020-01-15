import binaryT.ThreadedBinarySearchTree
import javasrc.MainJ
import kotlinsrc.MainK
import line_search.SearcherThread
import java.util.*
import kotlin.concurrent.thread

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
        linearSearch()
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
                        } catch (e: InputMismatchException) {
                            break
                        }
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
    //linear thread search
    private fun linearSearch() {

        val listInt = listOf( 1, 2, 3, 4, 5, 6, 7 )
        val key = 3
        val searchThread = SearcherThread(listInt.toIntArray(), key);
        searchThread.start()
        notBlockingTest()
        try {
            searchThread.join();
        } catch (e: InterruptedException) {
            e.printStackTrace()

        }
        println(searchThread.result)
    }

    private fun notBlockingTest() {
        var i = 0
        while (i < 1000) {
            i++
            Thread.sleep(100)
            println(i)
        }
    }
}