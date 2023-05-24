package com.example.cafes

import com.example.cafes.repositorios.UserRepository
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var ur : UserRepository = UserRepository()
        ur.init()
        ur.getUserList()

    }
}