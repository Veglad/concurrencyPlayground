package threadpool

import printLine
import java.util.concurrent.Executors

val threadPool = Executors.newFixedThreadPool(10)

fun main() {
    for (i in 0..1000) {
        threadPool.submit {
            val name = getUserNameById(i)
            printLine("User name [$i] - $name")
        }
    }
}

fun getUserNameById(id: Int): String {
    val nameCreator = ThreadSafeNameCreator.nameCreator.get()
    return nameCreator.getNameById(id.toString())
}

class ThreadSafeNameCreator {
    companion object {
        val nameCreator = object: ThreadLocal<NameCreator>() {
            override fun initialValue(): NameCreator {
                return NameCreator(Thread.currentThread().id.toString())
            }
        }
    }
}
