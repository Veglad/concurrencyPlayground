import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope

fun main() {
    runBlocking {
        val mainContext = coroutineContext

        launch(Dispatchers.IO) {
            val service = JsonPlaceholderFactory.makeRetrofitService()
            printLine("Fetching posts")
            val res = service.getPosts()

            withContext(mainContext) {
                printLine(res.body())
            }
        }

        launch(Dispatchers.Default) {
            repeat(1000) {
                printLine("Wait...")
                delay(500)
            }
        }
    }
}

fun printLine(str: Any?) {
    val threadDescription = "Msg from ${Thread.currentThread().name}: "
    println("${threadDescription}${str}")
}
