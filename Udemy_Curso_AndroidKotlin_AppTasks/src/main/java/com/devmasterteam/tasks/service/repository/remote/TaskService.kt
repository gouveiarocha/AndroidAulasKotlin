package com.devmasterteam.tasks.service.repository.remote

import com.devmasterteam.tasks.service.model.TaskModel
import retrofit2.Call
import retrofit2.http.*

interface TaskService {

    @GET("Task")
    fun list(): Call<List<TaskModel>>

    @GET("Task/Next7Days")
    fun listNext(): Call<List<TaskModel>>

    @GET("Task/Overdue")
    fun listOverduo(): Call<List<TaskModel>>

    // Específico para obter apenas uma tarefa.
    // No caso abaixo, devemos passar um id no endpoint - portanto, usamos a URL conforme abaixo e
    // mapeamos usando o @Path. O encoded corrige automaticamente urls que contiver espaços e\ou
    // caracteres especiais.
    @GET("Task/{}")
    fun load(@Path(value = "id", encoded = true) id: Int): Call<TaskModel>

    // Inserir Tarefa.
    @POST("Task")
    @FormUrlEncoded
    fun create(
        @Field("PriorityId") priorityId: Int,
        @Field("Description") description: String,
        @Field("DueDate") dueDate: String,
        @Field("Complete") complete: Boolean
    ): Call<Boolean>

    // Atualizar Tarefa.
    @PUT("Task")
    @FormUrlEncoded
    fun update(
        @Field("Id") id: Int,
        @Field("PriorityId") priorityId: Int,
        @Field("Description") description: String,
        @Field("DueDate") dueDate: String,
        @Field("Complete") complete: Boolean
    ): Call<Boolean>

    // Marcar tarefa como completa.
    @PUT("Task/Complete")
    @FormUrlEncoded
    fun complete(
        @Field("Id") id: Int
    ): Call<Boolean>

    // Marcar tarefa como não completa.
    @PUT("Task/Undo")
    @FormUrlEncoded
    fun undo(
        @Field("Id") id: Int
    ): Call<Boolean>

    // Deletar Tarefa.
    @HTTP(method = "DELETE", path = "Task", hasBody = true)
    @FormUrlEncoded
    fun delete(
        @Field("Id") id: Int
    ): Call<Boolean>

}