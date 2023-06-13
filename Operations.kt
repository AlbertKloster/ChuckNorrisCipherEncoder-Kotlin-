package chucknorris

enum class Operations(val operation: String) {
    ENCODE("encode"),
    DECODE("decode"),
    EXIT("exit");

    companion object {
        fun getOperation(input: String): Operations {
            for (operation in Operations.values()) {
                if (operation.operation == input.lowercase()) {
                    return operation
                }
            }
            throw RuntimeException("There is no '$input' operation")
        }
    }
}