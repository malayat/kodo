package solmedia.ec.kodo.model

data class Todo(
    var message: String? = "",
    var priority: Int = 10
) {
    val style: String
        get() = when (message?.length) {
            in 0 until 30 -> "text-short"
            in 31 until 60 -> "text-medium"
            in 61 until 120 -> "text-long"
            else -> "text-longest"
        }
}