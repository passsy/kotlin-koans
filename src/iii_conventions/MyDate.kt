package iii_conventions

data class MyDate(var year: Int, var month: Int, var dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = size() - other.size()

    fun size(): Int = dayOfMonth + month * 100 + year * 10000
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}


class DateRange(override val start: MyDate, override val endInclusive: MyDate) : Comparable<DateRange>, ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        var now: MyDate = start

        override fun next(): MyDate {
            if (now === start) {
                now = start.copy()
                return now
            }
            now = now.nextDay()
            return now
        }

        override fun hasNext(): Boolean {
            return now.nextDay() <= endInclusive
        }

    }

    override fun compareTo(other: DateRange): Int = length() - other.length()

    fun length(): Int = endInclusive.size() - start.size()

}