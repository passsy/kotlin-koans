package iii_conventions

import iii_conventions.TimeInterval.*
import util.TODO

fun todoTask29(): Nothing = TODO(
        """
        Task 29.
        Implement a kind of date arithmetic. Support adding years, weeks and days to a date.
        Use classes MyDate and TimeInterval.
        Use a utility function MyDate.addTimeIntervals.
        Uncomment the commented line and make it compile.

        (1). Add an extension function 'plus()' to MyDate, taking a TimeInterval as an argument.
        (2). Support adding several time intervals to a date. Add an extra class.
        If you have any problems, see the iii_conventions/_29_Tips.kt file.
    """,
        references = { date: MyDate, timeInterval: TimeInterval ->
            date.addTimeIntervals(timeInterval, 1)
        })

fun task29_1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task29_2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

class MultipleTimeInterval(val interval: TimeInterval, var count: Int)

operator fun TimeInterval.times(i: Int): MultipleTimeInterval {
    return MultipleTimeInterval(this, i);
}

operator fun MyDate.plus(interval: TimeInterval): MyDate {
    when (interval) {
        YEAR -> year += 1
        WEEK -> dayOfMonth += 7
        DAY -> dayOfMonth += 1
    }

    // fake day to months
    if (dayOfMonth >= 31) {
        month += dayOfMonth / 31
        dayOfMonth %= 31;
    }

    if (dayOfMonth >= 12) {
        year += month / 12
        month %= 12;
    }

    return this
}

operator fun MyDate.plus(multipleInterval: MultipleTimeInterval): MyDate {
    for (i in 0..multipleInterval.count - 1) {
        plus(multipleInterval.interval)
    }
    return this
}

