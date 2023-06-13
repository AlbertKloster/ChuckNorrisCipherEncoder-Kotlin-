package chucknorris

class Converter {
    fun charToBinaryString(char: Char): String {
        val binaryString = StringBuilder()
        for (i in 6 downTo 0) {
            binaryString.append(if (char.code and (1 shl i) != 0) '1' else '0')
        }
        return binaryString.toString()
    }
}