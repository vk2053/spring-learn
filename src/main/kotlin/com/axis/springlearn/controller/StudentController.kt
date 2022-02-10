package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
class StudentController(@Autowired val studentService: StudentService) {






}