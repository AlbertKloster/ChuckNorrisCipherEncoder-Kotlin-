package chucknorris

class UserInterface {

    private val chuckNorrisCoder = ChuckNorrisCoder()
    fun run() {
        var exit = false
        while (!exit) {
            printMenu()
            try {
                when (Operations.getOperation(readln())) {
                    Operations.DECODE -> decode()
                    Operations.ENCODE -> encode()
                    Operations.EXIT -> exit = true
                }
            } catch (e: RuntimeException) {
                println(e.message)
            }
        }
        println("Bye!")
    }

    private fun encode() {
        println("Input string:")
        val string = readln()
        println("Encoded string:")
        println(chuckNorrisCoder.encode(string))
    }

    private fun decode() {
        println("Input encoded string:")
        val encodedString = readln()
        val decodeString = chuckNorrisCoder.decode(encodedString)
        println("Decoded string:")
        println(decodeString)
    }

    private fun printMenu() {
        println("Please input operation (encode/decode/exit):")
    }

}