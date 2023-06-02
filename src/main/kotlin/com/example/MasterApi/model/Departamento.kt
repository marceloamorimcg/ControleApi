package com.example.MasterApi.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "dept")
data class Departamento(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_sequence")
    @JsonProperty(value = "deptno", access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "deptno")
    val deptno: Int? = null,
    @Column(length = 14)
    var dname: String? = null,
    @Column(length = 13)
    var loc: String? = null
)
