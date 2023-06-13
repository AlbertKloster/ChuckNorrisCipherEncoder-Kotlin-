package chucknorris

fun main() {
    val encryptor = Encryptor()
    println("Input string:")
    val message = readln()
    println("The result:")
    println(encryptor.encrypt(message))
}