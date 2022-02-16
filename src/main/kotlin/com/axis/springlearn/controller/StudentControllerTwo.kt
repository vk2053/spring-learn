package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentServiceTwo
import org.springframework.beans.factory.annotation.Autowired
import io.swagger.v3.oas.annotations.Operation
import org.springframework.context.MessageSource
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.context.support.AbstractMessageSource
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class StudentControllerTwo(
    @Autowired val studentService: StudentServiceTwo,
    @Autowired val messageSource: MessageSource
    ) {

    //Hello World
    @GetMapping("/helloworld")
    fun helloworld(@RequestHeader(name = "Accept-Language", required = false) locale: Locale): String?{
        return messageSource.getMessage("com.axis.key.helloworld", null, "Welcome to Axis Bank Default", locale)
    }

    //get all students
    @GetMapping("/students")
    fun getStudents(): List<Student> {
        return studentService.retrieveAllStudents()
    }

    //Get Student by ID
    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id: Int): Student {
        // WebMvcLinkBuilder

        val student = studentService.retrieveStudent(id)
        val link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.javaClass).getStudents()).withRel("likeAction")
        return student.get().add(link)
    }

    //Add Student
    @Operation(description = "Description", summary = "Summary")
    @PostMapping("/student")
    fun addStudent(@Valid @RequestBody student: Student): Student {
        return studentService.add(student)
    }


    //Delete Student by ID
    @DeleteMapping("/student/{id}")
    fun deleteStudent(@PathVariable id: Int) {
        return studentService.removeStudent(id)
    }

    //Edit Student
    @PutMapping("/student")
    fun editStudent(@RequestBody student: Student): Student {
        return studentService.edit(student)
    }



}