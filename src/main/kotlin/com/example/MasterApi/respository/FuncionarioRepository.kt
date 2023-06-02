package com.example.MasterApi.respository

import com.example.MasterApi.model.Funcionario
import org.springframework.data.repository.CrudRepository

interface FuncionarioRepository: CrudRepository<Funcionario, Int>