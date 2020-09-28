package scattergatherpattern

import printLine
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class ProductService {
    fun getAllProducts(): List<String> {
        val products = Collections.synchronizedList(mutableListOf<String>())

        val amazonProductsTask = CompletableFuture.runAsync(RetrieveProductTask("Amazon", products))
        val appleProductsTask = CompletableFuture.runAsync(RetrieveProductTask("Apple", products))
        val googleProductsTask = CompletableFuture.runAsync(RetrieveProductTask("Google", products))

        val allTasks = CompletableFuture.allOf(amazonProductsTask, appleProductsTask, googleProductsTask)
        try {
            allTasks.get(3, TimeUnit.SECONDS)
        } catch (e: Exception) {}

        return products
    }
}

class RetrieveProductTask(val productType: String, val products: MutableList<String>): Runnable {
    override fun run() {
        val fetchTime = Random.nextLong(1000, 4000)
        printLine("Running [$productType] fetcher. Expected retrieving time - $fetchTime ms")
        Thread.sleep(fetchTime)

        products.add("[$productType] Product#${Random.nextInt()}")
        products.add("[$productType] Product#${Random.nextInt()}")
    }
}
