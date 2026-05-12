fun main() {
    val numbers = arrayOf(10, 25, 5, 40, 15)

    var max = numbers[0]
    for (num in numbers) {
        if (num > max) {
            max = num
        }
    }

    println("Maximum value: $max")

    val numberList = numbers.toList()
    println("List: $numberList")
}