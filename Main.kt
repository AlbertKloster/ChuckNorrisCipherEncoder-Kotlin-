package chucknorris

fun main() {
    val converter = Converter()
    println("Input string:")
    val message = readln()
    println("The result:")
    for (char in message) {
        println("$char = ${converter.charToBinaryString(char)}")
    }
}