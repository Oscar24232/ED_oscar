package Direccion_Ip/*fun main() {
    println("Dame una IP")
    var numeroIp = readln().toString()


}
    fun comprobarClase(IP: Direccion) {
        var punto: Char = '.'
        var contadorPuntos = 0
        var acum = ""
        var byte1 = ""
        var byte2 = ""
        var byte3 = ""
        var byte4 = ""
        var numeroBinario1=0
        var binario=0
        var acumuladorBinario=""
        var resultado=0
        //dividir la IP en byte1, byte2, byte3, byte4
        for (i in IP) {
            if (i.isDigit()) {
                var digito = Character.getNumericValue(i)
                acum += i
            }
            if (i == punto) {
                contadorPuntos += 1
                if (contadorPuntos == 1) {
                    byte1 = acum
                    println("byte1: $byte1")
                    acum = ""
                } else if (contadorPuntos == 2) {
                    byte2 = acum
                    println("byte 2: $byte2")
                    acum = ""
                } else if ((i == punto) && (contadorPuntos == 3)) {
                    byte3 = acum
                    println("byte3: $byte3")
                    acum = ""
                }
            }
        }
                byte4 = acum
                println("byte4: $byte4")
                acum = ""
        //Saber binario del primer byte
        numeroBinario1=byte1.toInt()
        while (numeroBinario1>0) {
            resultado=numeroBinario1/2
            binario = numeroBinario1 % 2
            acumuladorBinario = binario.toString() + acumuladorBinario
            numeroBinario1=resultado
        }
        println(acumuladorBinario)

    }*/






