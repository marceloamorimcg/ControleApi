package com.example.MasterApi.controller

import com.example.MasterApi.model.Departamento
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/departamento")
class DepartamentoController(
    val service: DepartamentoService
) {
    @GetMapping
    fun listAll(): List<Departamento> = service.getAll()

    @PostMapping()
    fun create(@RequestBody departamento: Departamento): Departamento{
        return service.create(departamento)
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody departamento: Departamento): Departamento{
        return service.update(id, departamento)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int){
        service.delete(id)
    }
}