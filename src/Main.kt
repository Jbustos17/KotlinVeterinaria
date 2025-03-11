fun main() {
    val mascotas = mutableListOf<Mascota>()
    val consultas = mutableListOf<ConsultaMedica>()

    while (true) {
        println("1. AGREGAR MASCOTA")
        println("2. REGISTRAR CONSULTA MEDICA")
        println("3. MOSTRAR MASCOTAS")
        println("4. MOSTRAR HISTORIAL DE CONSULTAS")
        println("5. MODIFICAR DATOS DE MASCOTA")
        println("6. CALCULAR COSTO TOTAL DE CONSULTAS")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Especie: ")
                val especie = readLine() ?: ""

                var edad: Int? = null
                while (edad == null) {
                    print("Edad: ")
                    edad = readLine()?.toIntOrNull()
                    if (edad == null || edad < 0) {
                        println(" Edad invalida")
                        edad = null
                    }
                }

                print("Peso: ")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0
                mascotas.add(Mascota(nombre, especie, edad, peso))
                println(" Mascota agregada con exito.")
            }

            2 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombre = readLine() ?: ""
                val mascota = mascotas.find { it.nombre == nombre }
                if (mascota != null) {
                    print("Fecha de la consulta (DD/MM/AAAA): ")
                    val fecha = readLine() ?: ""
                    print("Diagnostico: ")
                    val diagnostico = readLine() ?: ""
                    print("Incluye medicacion? (true/false): ")
                    val incluyeMedicacion = readLine()?.toBoolean() ?: false
                    print("Costo base: ")
                    val costoBase = readLine()?.toDoubleOrNull() ?: 0.0

                    consultas.add(
                        ConsultaMedica(
                            mascota.nombre, mascota.especie, mascota.edad, mascota.peso,
                            fecha, diagnostico, incluyeMedicacion, costoBase
                        )
                    )
                    println("Consulta registrada exitosamente.")
                } else {
                    println("Mascota no encontrada.")
                }
            }

            3 -> mascotas.forEach { println(it.describirMascota()) }

            4 -> consultas.forEach { println(it) }

            5 -> {
                print("Ingrese el nombre de la mascota a modificar: ")
                val nombre = readLine() ?: ""
                val mascota = mascotas.find { it.nombre == nombre }
                if (mascota != null) {
                    print("Nuevo peso: ")
                    val nuevoPeso = readLine()?.toDoubleOrNull()
                    if (nuevoPeso != null) {
                        mascota.actualizarPeso(nuevoPeso)
                        println(" Peso actualizado con exito.")
                    } else {
                        println("Entrada invalida.")
                    }
                } else {
                    println("Mascota no encontrada.")
                }
            }

            6 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombre = readLine() ?: ""
                val costoTotal = consultas.filter { it.nombre == nombre }.sumOf { it.calcularCosto() }
                println("Costo total de consultas de $nombre: $$costoTotal")
            }

        }
    }
}
