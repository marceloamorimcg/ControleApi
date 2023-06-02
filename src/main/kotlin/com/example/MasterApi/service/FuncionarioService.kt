package com.example.MasterApi.service

import com.example.MasterApi.model.Funcionario
import org.springframework.stereotype.Service

@Service
class FuncionarioService(
    val db: FuncionarioRepository,
    val departamentoService: DepartamentoService)
{
    fun create(funcionario: Funcionario): Funcionario = db.save(funcionario)
    fun delete(id: Int){
        if(db.existsById(id)){
            db.deleteById(id)
        }
    }
    fun getAll(): List<Funcionario> = db.findAll() as List<Funcionario>

    fun update(id: Int, funcionario: Funcionario): Funcionario{
        if (db.existsById(id)){
            val safeFuncionario = funcionario.copy(id)
            return db.save(safeFuncionario)
        }
        return Funcionario()
    }
    fun addDepartamento(id: Int, departamentpId: Int): Funcionario{
        val funcionario = db.findById(id)
        if (funcionario.isPresent){
            val departament = departamentoService.getById(id)
            if(departament.isPresent){
                funcionario.get().deptno = departament.get()
                return db.save(funcionario.get())
            }
        }
        return Funcionario()
    }
    fun removeDepartamento(id: Int, departamentpId: Int): Funcionario{
        val funcionario = db.findById(id)
        if(funcionario.isPresent){
            funcionario.get().deptno = null
            db.save(funcionario.get())
        }
        return Funcionario()
    }

    fun addGerente(id: Int, gerenteId: Int): Funcionario{
        val funcionario = db.findById(id)
        if(funcionario.isPresent){
            val gerente = db.findById(gerenteId)
            funcionario.get().mgr = gerente.get()
            return db.save(funcionario.get())
        }
        return Funcionario()
    }

    fun removeGerente(gerenteId: Int): Funcionario{
        val funcionario = db.findById(gerenteId)
        if (funcionario.isPresent){
            funcionario.get().mgr = null
            return db.save(funcionario.get())
        }
        return Funcionario()
    }
}