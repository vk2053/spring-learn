package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentServiceTwo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
class StudentControllerTwo(@Autowired val studentService: StudentServiceTwo) {


    //Get all students
 //   @GetMapping("/students")
  //  fun getStudents(): MutableList<Student> {
   //     return studentService.findAll()

   // }



   // @GetMapping("/student/{id}")
  //  fun getPathVariable(@PathVariable id : Int): Student? {
   //     println("Start")
    //    val student = studentService.findOne(id)
    //    return student

  //  }
    //Add Student
    @PostMapping("/student")
    fun addStudent(@RequestBody student: Student): Student {
        return studentService.add(student)
    }

    //Delete Student
    // @DeleteMapping("/student/{id}")
    // fun deleteStudent(@PathVariable id: Int): String? {
    //    return studentService.delete(id)
    //  }

    //Edit Student
    // @PutMapping("/student")
    // fun editStudent(@RequestBody student: Student): Boolean {
    //     return studentService.saveOrUpdate(student)
    //  }



}