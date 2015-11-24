package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = size() - other.size()

    fun size(): Int = dayOfMonth + month * 100 + year * 10000
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}


class DateRange(override val start: MyDate, override val endInclusive: MyDate) : Comparable<DateRange>, ClosedRange<MyDate> {
    
    override fun compareTo(other: DateRange): Int = lenght() - other.lenght()

    fun lenght(): Int = endInclusive.size() - start.size()

}