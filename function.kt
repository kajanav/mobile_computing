fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    print("Enter first number: ")
    val a = readLine()!!.toInt()

    print("Enter second number: ")
    val b = readLine()!!.toInt()

    val result = addNumbers(a, b)
    println("Sum is: $result")
}