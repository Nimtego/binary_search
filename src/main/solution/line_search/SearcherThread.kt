package line_search

class SearcherThread(private val array: IntArray,
                     private val key: Int
) : Thread() {
    var result: Int = 0
    private val notFound = -1

    override fun run() {
        for (value in array) {
            sleep(1200)
            println("From thread search: value - $value")
            if (key == value) {
                result = key
                break
            }
            result = notFound
        }
    }
}
