
open class Mascota (

    val nombre : String,
    val especie : String,
    var edad : Int,
    var peso : Double,
){
    fun actualizarPeso(nuevoPeso: Double) {
        peso = nuevoPeso
    }
    fun incrementarEdad(){
    edad++
    }
    fun describirMascota(): String {
        return "Nombre: $nombre, Especie: $especie, Edad: $edad años, Peso: $peso kg"
    }


}



