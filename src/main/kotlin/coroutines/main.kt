package coroutines

import kotlinx.coroutines.*
import printLine

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
