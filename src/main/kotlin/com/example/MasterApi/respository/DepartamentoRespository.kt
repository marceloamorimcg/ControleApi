package com.example.MasterApi.respository

import com.example.MasterApi.model.Departamento
import org.springframework.data.repository.CrudRepository

interface DepartamentoRespository: CrudRepository<Departamento, Int>