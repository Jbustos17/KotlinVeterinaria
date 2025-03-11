class ConsultaMedica(nombre: String, especie: String, edad: Int, peso: Double, val fecha: String, val diagnostico: String, private val incluyeMedicacion: Boolean, private val costoBase: Double) : Mascota(nombre, especie, edad, peso) {

    fun calcularCosto(): Double {
        return if (incluyeMedicacion) costoBase * 1.15 else costoBase
    }

    override fun toString(): String {
        return " Consulta para $nombre - Fecha: $fecha - Diagnóstico: $diagnostico - Costo: ${calcularCosto()}"
    }
}
