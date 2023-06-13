package chucknorris

class Encryptor {
    fun encrypt(message: String): String {
        val encryptedMessage = StringBuilder()
        var count = 0
        var lastChar: Char? = null
        for (char in stringToBinaryString(message)) {
            when (lastChar) {
                null -> {
                    lastChar = char
                    count++
                }
                char -> count++
                else -> {
                    encryptedMessage.append(getStringToAppend(lastChar, count))
                    lastChar = char
                    count = 1
                }
            }
        }
        encryptedMessage.append(getStringToAppend(lastChar, count))
        return encryptedMessage.toString().trim()
    }

    private fun getStringToAppend(lastChar: Char?, count: Int): StringBuilder {
        val stringToAppend = StringBuilder()
        stringToAppend.append(if (lastChar == '1') "0 " else "00 ")
        stringToAppend.append("0".repeat(count))
        stringToAppend.append(" ")
        return stringToAppend
    }

    private fun stringToBinaryString(string: String): String {
        val binaryString = StringBuilder()
        for (char in string) {
            binaryString.append(charToBinaryString(char))
        }
        return binaryString.toString()
    }

    private fun charToBinaryString(char: Char): String {
        val binaryString = StringBuilder()
        for (i in 6 downTo 0) {
            binaryString.append(if (char.code and (1 shl i) != 0) '1' else '0')
        }
        return binaryString.toString()
    }
}