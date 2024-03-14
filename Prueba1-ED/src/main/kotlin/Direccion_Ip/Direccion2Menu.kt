package Direccion_Ip

class Direccion2Menu {
    var iP = ""
    var byte1 = ""
    var byte2 = ""
    var byte3 = ""
    var byte4 = ""
    var validar=false
        private set


    constructor(iP: String) {
        this.iP = iP
    }

    //Esta funcion se utiliza para partir en bytes y que se muestren
    fun MostrarpartirBytes(Ip: String) {
        var punto: Char = '.'
        var contadorPuntos = 0
        var acum = ""
        partirBytes(this.iP)

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
                    } else if (contadorPuntos == 3) {
                        byte3 = acum
                        print("byte3: $byte3| ")
                        acum = ""
                    }
                }
            }
            byte4 = acum
            print("byte4: $byte4")
            println()
        }


    fun partirBytes(ip: String) {        //Para poder mostrar la clase sin tener que mostrar el partir de los bytes de la red
        var punto: Char = '.'
        var contadorPuntos = 0
        var acum = ""

        for (i in ip) {
            if (i.isDigit()) {
                acum += i
            }
            if (i == punto) {
                contadorPuntos += 1
                if (contadorPuntos == 1) {
                    byte1 = acum
                    acum = ""
                } else if (contadorPuntos == 2) {
                    byte2 = acum
                    acum = ""
                } else if ((i == punto) && (contadorPuntos == 3)) {
                    byte3 = acum
                    acum = ""
                }
            }
        }
        byte4 = acum

        acum = ""


    }

    //Esta otra funcion se utiliza para hacer los numeros binarios
    fun binario(byte: String) {

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
        for (i in acumuladorBinario) {          //Para rellenar huecos para los 8 bits de cada numero binario
            contador += 1
        }
        while (contador < 8) {
            acumuladorBinario = "0" + acumuladorBinario
            contador += 1
        }
        print("$acumuladorBinario|")
    }

    //Funcion que se utilizar para comprobar el tipo de red que es.
    fun comprobarClaseRed(): String {
        var resultado = ""
        partirBytes(iP)        //Debe estar para la particion de la iP para la funcion Menu de la factoria.
        var redByte = byte1
            if ((redByte.toInt() >= 0) && (redByte.toInt() <= 127)) {

                resultado = "Es red: Clase A " +
                        "${this.byte1} representa la red, y ${this.byte2} ${this.byte3}.${this.byte4} estos bytes represtan el host"
            }
            if ((redByte.toInt() >= 128) && (redByte.toInt() <= 191)) {
                resultado = "Es red: Clase B " +
                        "${this.byte1}.${this.byte2} representa la red, y ${this.byte3}.${this.byte4} estos bytes represtan el host"
            }
            if ((redByte.toInt() >= 192) && (redByte.toInt() <= 223)) {

                resultado = "Es red: Clase C " +
                        "${this.byte1}.${this.byte2}.${this.byte3} representa la red, y ${this.byte4} estos bytes represtan el host"
            }
            if ((redByte.toInt() >= 224) && (redByte.toInt() <= 239)) {

                resultado = "Es red: Clase D"
            } else if ((redByte.toInt() >= 240) && (redByte.toInt() <= 255)) {
                println()
                resultado = "Es red Clase E"
            }


        return resultado
    }
    //VER TIPO DE MASCARA QUE UTILIZA DEPENDIENDO EL TIPO DE RED QUE ES
    fun mascara() {


            partirBytes(iP) //Debe estar para la particion de la iP para la funcion Menu de la factoria.
            var byte = this.byte1
            if ((byte.toInt() >= 0) && (byte.toInt() <= 127)) {
                println("Mascara de red: 255.0.0.0/8")   //8 bits primeros representan la red claseA
            } else if ((byte.toInt() >= 128) && (byte.toInt() <= 191)) {
                println("Mascara de red: 255.255.0.0/16")   //16 bits primeros representan la red claseB
            } else if ((byte.toInt() >= 192) && (byte.toInt() <= 223)) {
                println("Mascara de red: 255.255.255.0/24")   //24 bits primeros representan la red claseC
            } else if ((byte.toInt() >= 224) && (byte.toInt() <= 239)) {
                println(
                    "Mascara de red: No se usa tipicamente con notacion decimal" +
                            "ya que las direcciones de clase D se utilizan para multicast."
                )   //24 bits primeros representan la red
            } else if ((byte.toInt() >= 240) && (byte.toInt() <= 255)) {
                println(
                    "Mascara de red: No se usa tipicamente con notacion decimal" +
                            "son reservadas para usos experimentales"
                )   //24 bits primeros representan la red
            }
        }

    //LA DIRECCION DEL ROUTER PARA SABER LA PUERTA DE ENLACE
    fun puertaRouter(iP: String) {
        partirBytes(iP)
            var byteEn = this.byte1
            var byteEn2 = this.byte2
            var byteEn3 = this.byte3
            var byteEn4 = "1"   //Toda puerta de enlace tiene una direccion que es la del router
            println("Puerta de Enlace(Gateway): $byteEn.$byteEn2.$byteEn3.$byteEn4")

    }

    fun publicaOPrivada():String {
        var resultado = ""
        partirBytes(iP)        //Debe estar para la particion de la iP para la funcion  Menu de la clase MENU .

            if (((this.byte1.toInt() >= 0) && (this.byte1.toInt() <= 127)) || (this.byte1.toInt() == 126) && (this.byte2.toInt() == 0) && (this.byte3.toInt() == 0) && (this.byte4.toInt() == 0)) {
                if ((this.byte1.toInt() == 10) && (this.byte2.toInt() >= 0) && (this.byte2.toInt() <= 255) && (this.byte3.toInt() >= 0) && (this.byte3.toInt() <= 255) && (this.byte4.toInt() >= 0) && (this.byte3.toInt() <= 255)) {
                    resultado = "Es Red Privada: Clase A"
                } else {
                    resultado = "Es Red Publica: Clase A"
                }
            }
            if ((this.byte1.toInt() >= 128) && (this.byte1.toInt() <= 191)) {
                if ((this.byte1.toInt() == 172) && (this.byte2.toInt() >= 16) && (this.byte2.toInt() <= 31) && (this.byte3.toInt() >= 0) && (this.byte3.toInt() <= 255) && (this.byte4.toInt() >= 0) && (this.byte4.toInt() <= 255)) {
                    resultado = "Es Red Privada: Clase B "

                } else {
                    resultado = "Es Red Publica: Clase B"
                }
            }
            if ((this.byte1.toInt() >= 192) && (this.byte1.toInt() <= 223)) {
                if ((this.byte1.toInt() == 192) && (this.byte2.toInt() == 168) && (this.byte3.toInt() >= 0) && (this.byte3.toInt() <= 255) && (this.byte4.toInt() >= 0) && (this.byte4.toInt() <= 255)) {

                    resultado = "Es Red Privada: Clase C "

                } else {
                    resultado = "Es Red Publica: Clase C"
                }
            }

        return resultado
    }
}
