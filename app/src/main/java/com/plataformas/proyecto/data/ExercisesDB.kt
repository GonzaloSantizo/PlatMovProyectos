package com.plataformas.proyecto.data

data class Exercises(
    val name: String,
    val description: String,
    val muscle : String,
    val image: String,

)

object ExercisesDB {

    private val exercisesList = mutableListOf(
        Exercises(
            name = "hip thrust",
            description = "Este ejercicio es vital para el fortalecimiento de los glúteos, y no solo eso, también trabaja de manera secundaria los cuadriceps e isquiosurales. Se puede levantar mucho peso fácilmente, pero evitar el ego, pues solo trea consecuencias.",
            muscle = "leg",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFqGktXgpMTSv7c5J4yUajpAofktcFYgOtsg&usqp=CAU"
        ),
        Exercises(
            name = "barbell squat",
            description = "Este ejercicio es perfecto para el desarrollo de los cuadriceps, peus involucra mayormente este musculo, aún así, no se deja de lado el trabajo a los gluteos y abductores. Se recomienda el uso de un peso adecuado, pues puede ser peligroso el exceder el mismo.",
            muscle = "leg",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRF-gaCJoX6CoIyFYeoPPGFdfI28vJSM1ivdg&usqp=CAU",
        ),
        Exercises(
            name = "press banca",
            description = "Este ejercicio es básico y utilizado mayormemte para trabajos de fuerza. Se puede utilizar también para hipertrofia, pero los pesos deberan bajar para poder sentir trabajar bien el pectoral. Los brazos deben formar un angulo de 90 grados cuando se realiza el ejercicio, de esta manera, se asegura el trabajo en el pectoral.",
            muscle = "chest",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSa6cnlzS0r-vrK7ogJr5YOjZ87EBkB2JasXg&usqp=CAU",
        ),
        Exercises(
            name = "dumbell millitary press",
            description = "Este ejercicio representa un trabajo de fuerza para la parte frontal y media del tricep, pues da tensión necesaria a los mismos, pero especialmente, a la parte lateral.",
            muscle = "shoulders",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR325r2hTSDiD2uK2Sne58-wsgMPXDn7D-oFw&usqp=CAU",
        ),
        Exercises(
            name = "bicep curl with dumbells",
            description = "Es recomendable el tarabajo con mancuera, la mayor parte del tiempo, hay un músculo más fuerte que otro, y esto ayuda para eliminar tales disbalances. Se recomienda poco peso, pues con poco peso y ejecución perfecta, se desarrollan los biceps.",
            muscle = "bicep",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_odK1hbCcMXPl3cxtwex9jt3Kj2QChXRK5Q&usqp=CAU",
        ),
        Exercises(
            name = "deadlift",
            description = "Este es un ejercicio excelete para la fuerza, pero depende de la forma en su ejecución, puede ser perfecto para el desarrollo de la parte posterior de las pienras. Se recomienda dejar el ego fuera, pues es muy sencillo de obtener lesiones por parte de este ejercicio.",
            muscle = "leg",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQL8WGRc2b16ov7T_0Hd_Se8k7Ae6GxC6A-IQ&usqp=CAU",
        ),
        Exercises(
            name = "dips",
            description = "Este es un buen ejercicio para trabajar la parte baja del pectoral mayor. Se puede trabajar fuerza con este ejercicio, pero no solo ello. No se recomienda bajar mucho o sobrecargar demasiado el ejercicio, las lesiones vendran en caso omiso.",
            muscle = "chest",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVNigfQxAHXSSLMqk7schPmbUtUN5seypQgg&usqp=CAU",
        ),
        Exercises(
            name = "barbell row",
            description = "Este ejercicio trabaja la espalda de manera horizontal, se debe tener precaución, pues al no tener sufiente fuerza, puede terminar siendo perjudicial para la espalda baja y ser una lesión. Se recomienda uso de cinturon y dejar fuera el ego.",
           muscle = "back",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBN-qnMrVOmpuITYR9-UiYLnSs_ISeHoAfbg&usqp=CAU",
        ),
        Exercises(
            name = "z-bar curls",
            description = "Este ejercicio es ideal para el trabajo de la cabea larga del bicep. La cabeza corta y braquial también se ven involucradas, pero no tanto como la cabez larga.",
            muscle = "bicep",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNA_9dzFEAtugO3-CjozXFs65KPZnHAHcvHA&usqp=CAU",
        ),
        Exercises(
            name = "posterior shoulder raises",
            description = "Este ejercicio es recomendado, pues la gran mayoría de las personas decide dejarlo de lado, sin saber que esta parte del hombro da uno resultado visual tipo 3D, siendo esto mejor a la vista.",
            muscle = "shoulders",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKnoqTXn_Dm2DtWO8SwleyjOEDRH3mi3-Zgg&usqp=CAU",
        ),
        Exercises(
            name = "hammer curl",
            description = "Este ejercicio es el mejor para desarrollar el braquial, pues le da un mejor aspecto al brazo y a su vez, genera un mejor desarrollo para la cabeza larga del bicep.",
            muscle = "bicep",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkQCDdT7EedMZmH-yqhtFAqLX0red7VKc_Wg&usqp=CAU",
        ),
        Exercises(
            name = "pull up",
            description = "Este es un ejercicio básico para el desarrollo de la espalda, y es que, involucra una gran parte de los musculos de la misma. Un inconveniente, es que posee una dificultad para poder realizarlo, pero no es imposibles.",
            muscle = "back",
            image = "https://cdn.shopify.com/s/files/1/0013/1471/7798/files/Man_doing_pullups_outside_on_bars_how_to_increase_grip_strength_medium.jpg?v=1561387454",
        ),
        Exercises(
            name = "lateral raises",
            description = "Este ejercicio es útil para darle énfasis a la cabeza media del tricep, pues es la que da un forma más redonda al mismo. No se recomienda el uso de pesos exagerados, pues tiene debilidades mecánicas el ejercicio.",
            muscle = "shoulders",
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        ),
        Exercises(
            name = "incline dumbell press",
            description = "Este ejercicio es perfecto para trabajar la parte clavicular del pectoral. Dependera del angulo del banco, pues menos inclinación representa un trabajo de hombro, menos inclinación, significa trabajo de la parte baja del pectoral.",
            muscle = "chest",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPHTSFPrTtIBBSBXP8gneeurkCYdD-Xk0XDQ&usqp=CAU",
        ),
        Exercises(
            name = "lat pull down",
            description = "Esta es una variatnes de la dominada, y es que, posee la cualidad que cualquier persona puede realizarlo, pues puede nivelar el peso de trabajo y progresar fácilmente en este. No se aconsejan los levantamientos de ego.",
            muscle = "back",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPHTSFPrTtIBBSBXP8gneeurkCYdD-Xk0XDQ&usqp=CAU",
        ),


    )

    fun getExercises() = exercisesList

}