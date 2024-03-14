package Direccion_Ip

/**
 * Esta clase Menu es propiamente la formacion de un menu, en esta clase trabaja de manera interna los metodos
 * de la funcion menu y por ello proporciona que para cada numero en el menu, instancia el metodo y
 *  pide al usuario que introduzca una direccion ip y muestra por consola la opcion que ha elegido el usuario
 *
 */
class Menu {
    companion object {

        private fun partir():String {

            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)
            val resultado = "${red.MostrarpartirBytes(resp)}"
            return resultado
        }
        private fun red(){
            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)
            println(red.comprobarClaseRed())

        }
        private fun mascara():String{
            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)
            var resultado="${red.mascara()}"
            return resultado
        }
        private fun gateWay():String{
            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)
            val resultado="${red.puertaRouter(resp)}"
            return resultado
        }
        fun todo() {
            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)

                red.MostrarpartirBytes(resp)
                print(red.comprobarClaseRed())
                println()
                red.mascara()
                println(red.publicaOPrivada())
                red.puertaRouter(resp)
            }



        private fun verBinario(){ //verlo para seguir
            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)
            red.partirBytes(resp)
            red.binario(red.byte1)
            red.binario(red.byte2)
            red.binario(red.byte3)
            red.binario(red.byte4)
        }
        private fun salir(){
            println( "Has salido del programa")
        }
        private fun publicaPrivada(){
            println("Red IP")
            val resp = readln().toString()
            val red = Direccion2Menu(resp)
            println( red.publicaOPrivada())
        }
        fun menu(): Any {
            var responder:Int
            do {
                println("Que es lo que desea hacer: Del (1 al 8) cualquier letra superior al 8 saldrá del programa" )
                println("1.Dividir tu red en bytes")
                println("2.Ver la clase red de tu direccion IP")
                println("3.Ver Mascara de Red")
                println("4.Puerta de Enlace(Gateway")
                println("5.Ver tu red en Binario")
                println("6. Ver si es publica o privada")
                println("7.Analizar toda la red")
                println("8. Salir")
                println("Esperando tu respuesta...")
                responder = readln().toInt()
            }while ((responder<1)||(responder>8))
            return when (responder) {
                1-> partir()
                2-> red()
                3-> mascara()
                4-> gateWay()
                5-> verBinario()
                6-> publicaPrivada()
                7-> todo()
                else-> salir()

            }
        }
    }
}