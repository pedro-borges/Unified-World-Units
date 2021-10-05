package pcb.uwu.utils

fun <T> identity() =
    { it: T -> it }

fun <A, B, C> ((B) -> C).butBefore(that: (A) -> B): (A) -> C =
    { this(that(it)) }

fun <A, B, C> ((A) -> B).andThen(that: (B) -> C): (A) -> C =
    { that(this(it)) }
