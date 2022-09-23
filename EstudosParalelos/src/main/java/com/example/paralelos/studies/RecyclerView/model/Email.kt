package com.example.paralelos.studies.RecyclerView.model

data class Email(
    val user: String,
    val subject: String,
    val preview: String,
    val data: String,
    val stared: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

class EmailBuilder {
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var data: String = ""
    var stared: Boolean = false
    var unread: Boolean = false

    fun build(): Email = Email(user, subject, preview, data, stared, unread, false)

}

fun email(block: EmailBuilder.() -> Unit): Email = EmailBuilder().apply(block).build()

fun fakeEmails(): MutableList<Email> = mutableListOf(
    email {
        user = "Facebook"
        subject = "Veja nossas dicas principais para conseguir fazer algo..."
        preview = "Olá, Douglas - tudo bem? Esse é um exemplo do primeiro email"
        data = "23 set"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Veja nossas dicas principais para conseguir fazer algo..."
        preview = "Olá, Douglas - tudo bem? Esse é um exemplo do segundo email"
        data = "10 jan"
        stared = true
    },
    email {
        user = "Instagram"
        subject = "Veja nossas dicas principais para conseguir fazer algo..."
        preview = "Olá, Douglas - tudo bem? Esse é um exemplo do terceiro email"
        data = "15 jun"
        unread = true
        stared = true
    },
    email {
        user = "Twitter"
        subject = "Veja nossas dicas principais para conseguir fazer algo..."
        preview = "Olá, Douglas - tudo bem? Esse é um exemplo do quarto email"
        data = "01 mar"
    }
)
