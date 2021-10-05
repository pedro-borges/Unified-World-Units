package pcb.uwu.util

fun <T> identity() =
    { it: T -> it }

fun <A, B, C> ((B) -> C).butBefore(that: (A) -> B): (A) -> C =
    { this(that(it)) }

fun <A, B, C> ((A) -> B).andThen(that: (B) -> C): (A) -> C =
    { that(this(it)) }

fun hash(vararg elements: Any?) =
    elements.asSequence().map { it.hashCode() }.reduce { accumulator, hash -> accumulator + hash * 31 }
