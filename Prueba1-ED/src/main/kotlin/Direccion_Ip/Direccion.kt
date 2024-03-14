package Direccion_Ip

/**
 * Esta clase funciona con metodos privados, lo hace de manera interna y da el resultado de
 * todos los metodos al introducir
 * la direccion ip ,
 * @constructor esta clase está hecha para que cuando se pase por teclado una direccion IP te devuelva todas,
 * las funciones que tiene la clase de direccion te proporciona los numeros binarios
 * comprobacion de ip que te dirá la clase de la direccion ip.
 */
class Direccion {
    var iP = ""
    var byte1 = ""
    private var byte2 = ""
    private var byte3 = ""
    private var byte4 = ""

    constructor(iP: String) {
        this.iP = iP
        partirBytes(iP)
        binario(this.byte1)
        binario(this.byte2)
        binario(this.byte3)
        binario(this.byte4)
        comprobarClaseRed(byte1)
        mascara(byte1)
        puertaRouter(this.iP)

    }
//Esta funcion se utiliza para partir en bytes
    fun partirBytes(Ip: String) {
        var punto: Char = '.'
        var contadorPuntos = 0
        var acum = ""
        for (i in Ip) {
            if (i.isDigit()) {
                acum += i
            }
            if (i == punto) {
                contadorPuntos += 1
                if (contadorPuntos == 1) {
                    byte1 = acum
                    print("byte1: $byte1|")
                    acum = ""
                } else if (contadorPuntos == 2) {
                    byte2 = acum
                    print("byte2: $byte2|")
                    acum = ""
                } else if ((i == punto) && (contadorPuntos == 3)) {
                    byte3 = acum
                    print("byte3: $byte3| ")
                    acum = ""
                }
            }
        }
        byte4 = acum
        print("byte4: $byte4")
        println()
        acum = ""

    }
//Esta otra funcion se utiliza para hacer los numeros binarios
    private fun binario(byte: String) {
        var numeroBinario1 = 0
        var binario = 0

        var resultado = 0
        var contador = 0
        var acumuladorBinario = ""
        numeroBinario1 = byte.toInt()

        while (numeroBinario1 > 0) {
            resultado = numeroBinario1 / 2
            binario = numeroBinario1 % 2
            acumuladorBinario = binario.toString() + acumuladorBinario
            numeroBinario1 = resultado

        }
        for (i in acumuladorBinario) {
            contador += 1
        }
        while (contador < 8) {
            acumuladorBinario = "0" + acumuladorBinario
            contador += 1
        }
        print("$acumuladorBinario|")
    }
//Funcion que se utiliza para comprobar el tipo de red que es.
    private fun comprobarClaseRed(byte:String) {
        if ((byte.toInt()>=1)&&(byte.toInt()<=126))
        {
            println()
            println("Es red: Clase A " +
                    "${this.byte1} representa la red, y ${this.byte2} ${this.byte3}.${this.byte4} estos bytes represtan el host")
        }
        if((byte.toInt()>=128)&&(byte.toInt()<=191))
        {   println()
            println("Es red: Clase B " +
                    "${this.byte1 }.${this.byte2} representa la red, y ${this.byte3}.${this.byte4} estos bytes represtan el host")
        }
        if((byte.toInt()>=192)&&(byte.toInt()<=223))
        {
            println()
            println("Es red: Clase C " +
                    "${this.byte1 }.${this.byte2}.${this.byte3} representa la red, y ${this.byte4} estos bytes represtan el host")
        }
        if((byte.toInt()>=224)&&(byte.toInt()<=239))
        {
            println()
            println("Es red: Clase D")
        }
        else if((byte.toInt()>=240)&&(byte.toInt()<=255))
        {
            println()
            println("Es red Clase E")
        }
    }
    private fun mascara(byte: String) {

        if ((byte.toInt() >= 1) && (byte.toInt() <= 126)) {
            println("Mascara de red: 255.0.0.0/8")   //8 bits primeros representan la red claseA
        }
        if ((byte.toInt() >= 128) && (byte.toInt() <= 191)) {
            println("Mascara de red: 255.255.0.0/16")   //16 bits primeros representan la red claseB
        }
        if ((byte.toInt() >= 192) && (byte.toInt() <= 223)) {
            println("Mascara de red: 255.255.255.0/24")   //24 bits primeros representan la red claseC
        }
        if ((byte.toInt() >= 224) && (byte.toInt() <= 239)) {
            println("Mascara de red: No se usa tipicamente con notacion decimal" +
                        "ya que las direcciones de clase D se utilizan para multicast.")   //24 bits primeros representan la red
        } else if ((byte.toInt() >= 240) && (byte.toInt() <= 255)) {
            println("Mascara de red: No se usa tipicamente con notacion decimal" +
                        "son reservadas para usos experimentales")   //24 bits primeros representan la red
        }
    }
    fun puertaRouter(iP: String){
        var byteEn=byte1
        var byteEn2=byte2
        var byteEn3=byte3
        var byteEn4="1"
        println("Puerta de Enlace(Gateway): $byteEn.$byteEn2.$byteEn3.$byteEn4")
    }
}



