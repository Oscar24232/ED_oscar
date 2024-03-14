package CuentaBancaria

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CuentaBancariaTest {
    var cuentaPruebas=CuentaBancaria()
    @Test
    fun getNumeroDeCuenta() {
    }

    @Test
    fun setNumeroDeCuenta() {
    }

    @Test
    fun getSaldo() {
    }

    @Test
    fun setSaldo() {
    }

    @Test
    fun numeroDeCuenta() {
    }

    @Test
    fun ingresarSaldo() {
        cuentaPruebas.vaciarCuenta()
        var saldoPrueba=cuentaPruebas.ingresarSaldo(50.0)

        Assertions.assertEquals(50.0,saldoPrueba,"Ha llenado")
    }

    @Test
    fun retirarSaldo() {
        cuentaPruebas.vaciarCuenta()
        var saldoPrueba=cuentaPruebas.retirarSaldo(50.0)

        Assertions.assertEquals(50.0,saldoPrueba,"Ha sacadoDinero")
    }

    @Test
    fun vaciarCuenta() {
        var saldoPrueba=cuentaPruebas.vaciarCuenta()
        Assertions.assertEquals(0.0,saldoPrueba, "ha fallado vaciar")
    }
}