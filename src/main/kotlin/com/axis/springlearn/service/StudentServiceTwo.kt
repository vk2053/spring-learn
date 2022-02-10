package com.axis.springlearn.service

import com.axis.springlearn.model.Student
import org.springframework.stereotype.Service
import com.axis.springlearn.exception.StudentNotFoundException
import com.axis.springlearn.respository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired

@Service
class StudentServiceTwo (@Autowired val studentRepository: StudentRepository){
    fun add(student: Student): Student {
        return studentRepository.save(student)
    }


}