class Student(val name: String, val age: Int, val marks: Int) {

    fun displayDetails() {
        println("Name: $name")
        println("Age: $age")
        println("Marks: $marks")
    }
}

fun main() {
    val student1 = Student("John", 20, 85)
    student1.displayDetails()
}