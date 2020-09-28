fun printLine(str: Any?) {
    val threadDescription = "Msg from ${Thread.currentThread().name}: "
    println("${threadDescription}${str}")
}
