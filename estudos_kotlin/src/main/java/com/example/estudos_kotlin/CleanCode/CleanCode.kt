package MyCodes

val MAX_PARTNERS = 3

fun main() {

    println(podeSerEireli(0))
    canEireli(5)

}

fun podeSerEireli(socios: Int) = socios <= 3 //badcode
fun canEireli(nPartners: Int) = nPartners <= MAX_PARTNERS //melhorou