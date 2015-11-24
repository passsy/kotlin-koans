package i_introduction._8_Smart_Casts

import util.TODO
import util.doc6

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        when (e) {
            is Num -> todoTask6(e)
            is Sum -> todoTask6(e)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun todoTask6(expr: Expr): Nothing = TODO(
        """
        Task 6.
        Rewrite 'JavaCode6.eval()' in Kotlin using smart casts and 'when' expression.
    """,
        documentation = doc6(),
        references = { JavaCode6().eval(expr) })

