package CuentaBancaria

class CuentaBancaria {
    var numeroDeCuenta = numeroDeCuenta()
    var saldo: Double = 0.0

    constructor() {
        this.numeroDeCuenta = numeroDeCuenta
        this.saldo = saldo
    }

    fun numeroDeCuenta(): StringBuilder {
        var numero = (1000..4000).random()
        var serieDeNumeros = StringBuilder()
        serieDeNumeros.append(numero).append("-")
        var numero1 = (1000..4000).random()
        serieDeNumeros.append(numero1).append("-")
        var numero2 = (1000..4000).random()
        serieDeNumeros.append(numero2).append("-")
        var numero3 = (1000..4000).random()
        serieDeNumeros.append(numero3)
        return serieDeNumeros
    }

    fun ingresarSaldo(dinero:Double):Double {
        var operacion = 0.0
            this.saldo += dinero
            return this.saldo
        }


    fun retirarSaldo(dinero: Double): Double {
        var operacion = 0.00
        if (dinero > this.saldo) {
            println("No puede retirar esa cantidad")
        } else if (dinero < this.saldo) {
            operacion = this.saldo - dinero
            this.saldo = operacion
        }
        return this.saldo
    }


    fun vaciarCuenta(): Double {
        this.saldo = 0.0
        return this.saldo
    }
}
