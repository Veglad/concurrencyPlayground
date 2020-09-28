package threadpool

class NameCreator(private val seed: String) {
    fun getNameById(id: String) = "user<$seed><$id>"
}
