package com.example.MasterApi.service

import com.example.MasterApi.model.Departamento
import com.example.MasterApi.respository.DepartamentoRespository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartamentoService(
    val db: DepartamentoRespository
) {
    fun create(department: Departamento): Departamento = db.save(department)

    fun delete(id: Int){
        if(db.existsById(id)){
            db.deleteById(id)
        }
    }

    fun getById(id: Int): Optional<Departamento> {
        return db.findById(id)
    }
    fun getAll(): List<Departamento> = db.findAll() as List<Departamento>

    fun update(id: Int, department: Departamento): Departamento{
        if (db.existsById(id)){
            val safeDepartamento = department.copy(deptno = id)
            return db.save(safeDepartamento)
        }
        return Departamento()
    }
}