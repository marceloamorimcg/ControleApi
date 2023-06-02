package com.example.MasterApi.controller

import com.example.MasterApi.model.Funcionario
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/funcionario")
class FuncionarioController(
    val service: FuncionarioService
) {
    @GetMapping
    fun listAll(): List<Funcionario> = service.getAll()

    @PostMapping
    fun create(@RequestBody funcionario: Funcionario): Funcionario{
        return service.create(funcionario)
    }

    @PutMapping("/{id}")
    fun alter(@PathVariable id: Int, @RequestBody funcionario: Funcionario): Funcionario{
        return service.update(id, funcionario)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int){
        return service.delete(id)
    }

    @PutMapping("/{id}/{departamentpId}")
    fun addDepartamento(@PathVariable id: Int, @PathVariable departamentpId: Int): Funcionario{
        return service.addDepartamento(id, departamentpId)
    }

    @DeleteMapping("{id}/department/{departmentId}")
    fun removeDepartamento(@PathVariable id: Int, @PathVariable departmentId: Int): Funcionario{
        return service.removeDepartamento(id,departmentId)
    }
    @PutMapping("{id}/gerente/{gerenteId}")
    fun addGerente(@PathVariable id: Int, @PathVariable gerenteId: Int): Funcionario{
        return service.addGerente(id, gerenteId)
    }
    @DeleteMapping("/gerente/{gerenteId}")
    fun removeGerente(@PathVariable gerenteId: Int): Funcionario{
        return service.removeGerente(gerenteId)
    }

}