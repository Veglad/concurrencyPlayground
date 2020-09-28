package scattergatherpattern

fun main() {
    println("Fetching products...")
    ProductService().getAllProducts().forEach {
        println("Fetched Product: $it")
    }
}
