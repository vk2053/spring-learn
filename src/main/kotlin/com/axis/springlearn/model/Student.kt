package com.axis.springlearn.model

import org.springframework.hateoas.RepresentationModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
data class Student(

    @Id
    @GeneratedValue
    var id : Int,
    @get:Size(min = 3, max = 8)
    var name : String,
    var gender : String,
    @get:Email(message = "Invalid Email")
    var email : String,
    @get:Pattern(regexp = "^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}") // AXXPK7448K
    var phone : String
    ) : RepresentationModel<Student>()

