package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
class StudentController(@Autowired val studentService: StudentService) {


    @GetMapping("/helloworld")
    fun helloWorld(): String{
        return "Hello World"

    }
    @GetMapping("/students")
    fun getStudents(): MutableList<Student> {
        return studentService.findAll()

    }
    @GetMapping("/path/{id}")
    fun getStudent(@PathVariable id : Int): String {

        return "Received $id"

    }



    @GetMapping("/student/{id}")
    fun getPathVariable(@PathVariable id : Int): Student? {
        println("Start")
        val student = studentService.findOne(id)
        return student

    }
    //Add Student
    @PostMapping("/student")
    fun addStudent(@RequestBody student: Student): Boolean {
        return studentService.saveOrUpdate(student)
    }

    //Delete Student
    @DeleteMapping("/student/{id}")
    fun deleteStudent(@PathVariable id: Int): String? {
        return studentService.delete(id)
    }

    //Edit Student
    @PutMapping("/student")
    fun editStudent(@RequestBody student: Student): Boolean {
        return studentService.saveOrUpdate(student)
    }



}