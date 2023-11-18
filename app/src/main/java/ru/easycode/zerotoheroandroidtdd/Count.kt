package ru.easycode.zerotoheroandroidtdd

interface Count {
    class Base(private val step: Int) : Count {

        init {
            if (step <1)
                throw IllegalStateException("Отрицательное значение не приемлемо")

        }
        override fun increment(number: String): String {
           val digits = number.toInt()
            val result = digits + step
            return  result.toString()
        }

    }

    fun increment(number: String): String
}