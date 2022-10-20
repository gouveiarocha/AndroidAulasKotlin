package com.example.paralelos.studies.Mockk

import io.mockk.every
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class CarTest {

    @Test
    fun without_mock_car_direction_north() {
        val car = Car()
        val direction = "norte"
        assertEquals(car.myDrive(direction), Car().NORTH)
    }

    @Test
    fun without_mock_car_direction_south() {
        val car = Car()
        val direction = "sul"
        assertEquals(car.myDrive(direction), Car().SOUTH)
    }

    @Test
    fun with_mock_car_direction_east() {
        val mock = mock<Car>() {
            on { myDrive("leste") } doReturn "mock impl"
        }
        org.mockito.kotlin.verify(mock).myDrive(Car().EAST)

//        verify { mock.drive() }
//        verify(mock).
//        every { car.myDrive("leste") } returns Car().EAST
        //assertEquals(mock.myDrive(""), Car().EAST)
    }

    @Test
    fun test1_with_mock_car_direction_incorrect() {
        val car = Car()
        val direction = "any other"
        assertEquals(car.myDrive(direction), Car().INCORRECT_DIRECTION)
    }

//    @Test
//    fun test1_with_mock() {
//        val car = mockk<Car>()
//        every { car.drive(Direction.EAST) } returns Result.OK
//        assertEquals(car.drive(Direction.EAST), Result.OK)
//    }

}