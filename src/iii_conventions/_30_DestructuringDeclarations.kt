package iii_conventions.multiAssignemnt

import util.TODO
import util.doc30

fun todoTask30(): Nothing = TODO(
        """
        Task 30.
        Read about destructuring declarations and make the following code compile by adding one word (after uncommenting it).
    """,
        documentation = doc30()
)

class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    operator fun component1() = year
    operator fun component2() = month
    operator fun component3() = dayOfMonth
}

fun isLeapDay(date: MyDate): Boolean {
    val (year, month, dayOfMonth) = date

    // 29 February of a leap year
    return year % 4 == 0 && month == 2 && dayOfMonth == 29
}