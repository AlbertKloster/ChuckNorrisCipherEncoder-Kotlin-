package chucknorris

class Encryptor {

    fun encrypt(message: String) = message.map { it }.joinToString(" ")
}