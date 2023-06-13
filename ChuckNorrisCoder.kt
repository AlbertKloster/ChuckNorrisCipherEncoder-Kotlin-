package chucknorris

class ChuckNorrisCoder {
    fun encode(message: String): String {
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

    fun decode(encodedMessage: String): String {
        val decodedMessage = StringBuilder()
        for (string in splitBinaryStringTo(unaryStringToBinaryString(encodedMessage))) {
            decodedMessage.append(binaryStringToChar(string))
        }
        return decodedMessage.toString()
    }

    private fun splitBinaryStringTo(binaryString: String): MutableList<String> {
        val split = mutableListOf<String>()
        for (i in binaryString.indices step 7) {
            split.add(binaryString.substring(i, i + 7))
        }
        return split
    }

    private fun binaryStringToChar(binaryString: String): Char {
        var char = 0
        for (bit in binaryString) {
            char = char shl 1 or (bit - '0')
        }

        return char.toChar()
    }

    private fun unaryStringToBinaryString(unaryString: String): String {
        val binaryString = StringBuilder()
        val strings = unaryString.split(" ")
        for (i in strings.indices step 2) {
            binaryString.append(getDigitValue(strings[i]).repeat(getNumberOfDigits(strings[i + 1])))
        }
        return binaryString.toString()
    }

    private fun getDigitValue(string: String): String {
        return if (string == "0") "1" else if (string == "00") "0" else throw RuntimeException("Wrong Input String!")
    }

    private fun getNumberOfDigits(string: String): Int {
        return if (string.matches(Regex("0+"))) string.length else throw RuntimeException("Wrong Input String!")
    }
}