package com.example.app_convidados.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// obs: no curso, essa classe é alterada para uso da lib room, após a conclusão do app convidados
// a implementação original abordada no curso utilizava uma classe database helper para manipular
// os dados e salvar no db

// Entidade
@Entity(tableName = "Guest")
class GuestModel{

    @PrimaryKey(autoGenerate = true) //define como chave primaria e autoincremento
    @ColumnInfo(name = "id") //define o nome da coluna, se não colocar, usa o nome da varivel
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "presence")
    var presense: Boolean = true

    //val id: Int = 0, var name: String, var presence: Boolean


}