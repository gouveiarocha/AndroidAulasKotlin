package com.devmasterteam.tasks.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.model.ValidationModel
import com.devmasterteam.tasks.service.repository.PriorityRepository
import com.devmasterteam.tasks.service.repository.TaskRepository

class TaskListViewModel(application: Application) : AndroidViewModel(application) {

    private val taskRepository = TaskRepository(application)
    private val priorityRepository = PriorityRepository(application.applicationContext)

    private val _tasks = MutableLiveData<List<TaskModel>>()
    var tasks: LiveData<List<TaskModel>> = _tasks

    private val _delete = MutableLiveData<ValidationModel>()
    var delete: LiveData<ValidationModel> = _delete

    private val _status = MutableLiveData<ValidationModel>()
    var status: LiveData<ValidationModel> = _status

    private var taskFilter = 0

    fun list(filter: Int) {
        taskFilter = filter
        val listener = object : APIListener<List<TaskModel>> {
            override fun onSuccess(result: List<TaskModel>) {
                result.forEach {
                    it.priorityDescription = priorityRepository.getDescription(it.priorityId)
                }
                _tasks.value = result
            }

            override fun onFailure(message: String) {
                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
            }

        }
        when(filter){
            TaskConstants.FILTER.ALL -> taskRepository.list(listener)
            TaskConstants.FILTER.NEXT -> taskRepository.listNext(listener)
            TaskConstants.FILTER.EXPIRED -> taskRepository.listOverduo(listener)
        }
    }

    fun delete(id: Int) {
        taskRepository.delete(id, object : APIListener<Boolean> {
            override fun onSuccess(result: Boolean) {
                list(taskFilter)
                _delete.value = ValidationModel()
            }

            override fun onFailure(message: String) {
                _delete.value = ValidationModel(message)
            }

        })
    }

    fun status(id: Int, complete: Boolean) {

        val listener = object : APIListener<Boolean> {
            override fun onSuccess(result: Boolean) {
                list(taskFilter)
                _status.value = ValidationModel()
            }

            override fun onFailure(message: String) {
                _status.value = ValidationModel(message)
            }
        }

        if (complete) {
            taskRepository.complete(id, listener)
        } else {
            taskRepository.undo(id, listener)
        }

    }

}