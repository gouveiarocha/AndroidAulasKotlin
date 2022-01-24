package MyCodes.SOLID

/**
 * Dependency Inversion Principle - Principio da inversão da Dependencia
 *  -Depender de abstrações, e não de implementações.
 *  -Modulos de alto nivel nao devem depender de modulos de baixo nivel. Ambos devem depender da Abstração
 *  -Abstrações não devem depender de detalhes, e sim detalhes de abstrações.
 */

//Primeiro código, violando a DIP
class MySQLConnection() {} //Módulo de baixo nivel

class PasswordReminder() {
    private lateinit var dbConnect: MySQLConnection

    //Alto acoplamento, a instancia da classe MySQLConnection esta sendo criada dentro do metodo
    //Ou poderia estar sendo criado dentro do construtor.
    fun connectDatabase() {
        this.dbConnect = MySQLConnection()
    }
}

class PasswordReminder2() { //Módulo de alto nivel.
    //Melhoramos um pouco, aplicando a inversao de dependencia. Mas ainda violamos alguns principios como
    //o OCP, perceba que, se precisarmos usar outro dipo de banco de dados, como Oracle, vamos ter problemas
    fun connectDatabase(dbConnect: MySQLConnection) {
        val dbConnect = MySQLConnection()
    }
}

//Agora vamos refatorar, trabalhando para uma interface e não para uma implementação
//Observar que agora, a classe password reminder não tem noção de qual tipo de conexao será utilizada
class PasswordReminder3() { //Módulo de alto nivel.
    private lateinit var dbConnection: DBConection
    //Melhoramos um pouco, aplicando a inversao de dependencia. Mas ainda violamos alguns principios como
    //o OCP, perceba que, se precisarmos usar outro dipo de banco de dados, como Oracle, vamos ter problemas
    fun connectDatabase(dbConnect: DBConection) {
        this.dbConnection = dbConnection
    }
}

interface DBConection {
    fun connect()
}

class MySQLConnectionDIP() : DBConection {
    override fun connect() {}
}

class OracleConnection() : DBConection {
    override fun connect() {}
}

class SQLServer() : DBConection {
    override fun connect() {}
}

