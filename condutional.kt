fun main() {
    print("Enter a number: ")
    val num = readLine()!!.toInt()

    if (num > 0) {
        println("Number is Positive")
    } else if (num < 0) {
        println("Number is Negative")
    } else {
        println("Number is Zero")
    }
}