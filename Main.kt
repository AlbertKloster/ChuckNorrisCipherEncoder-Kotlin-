package chucknorris

fun main() {
    val encryptor = Encryptor()
    println("Input string:")
    val message = readln()
    val encryptedMessage = encryptor.encrypt(message)
    println(encryptedMessage)
}