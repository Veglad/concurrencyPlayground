import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope

fun main() {
    runBlocking {
        launch {
            val service = NetworkService(createGitHubService())
            val res = service.loadContributorsSuspend("Veglad")
            print(res)
        }
    }
    GlobalScope.launch {
        repeat(1000) {
            delay(200)
            print("Wait...")
        }
    }
}
