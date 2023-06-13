package chucknorris

fun main() {
    val chuckNorrisCoder = ChuckNorrisCoder()
    println("Input encoded string:")
    val message = readln().trim()
    println("The result:")
    println(chuckNorrisCoder.decode(message))
}