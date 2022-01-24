package MyCodes.SOLID

/**
 * Single Responsability Principle - Principio da Responsabilidade Unica
 *  -Mais responsabilidades -> Maior Acoplamento -> Menor Coesão
 *  -Menos responsabilidades -> Menor Acoplamento -> Maior Coesão
 *  -Dificil de testar e mockar.
 * */

//Primeiro código. Violando o SRP, com alto acoplamento e baixa coesão, funções
//que não deveriam ser responsabilidade da order.
class Order {

    fun calculateSum() {}
    fun getItems() {}
    fun getItemsCount() {}
    fun addItem(itemId: Int) {}
    fun deleteItem(itemId: Int) {}

    fun printOrder() {}
    fun showOrder() {}

    fun load() {}
    fun save() {}
    fun update() {}
    fun delete() {}
}

//Segundo código, aplicando SRP e separando as responsábilidades.
class OrderSRP{
    fun calculateSum() {}
    fun getItems() {}
    fun getItemsCount() {}
    fun addItem(itemId: Int) {}
    fun deleteItem(itemId: Int) {}
}

class OrderRepository{
    fun load(orderId: Int) {}
    fun save(order: OrderSRP) {}
    fun update(order: OrderSRP) {}
    fun delete(order: OrderSRP) {}
}

class OrderViwer{
    fun printOrder(order: OrderSRP) {}
    fun showOrder(order: OrderSRP) {}
}