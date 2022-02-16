package com.axis.springlearn.service

import com.axis.springlearn.model.Student
import org.springframework.stereotype.Service
import com.axis.springlearn.exception.StudentNotFoundException
import com.axis.springlearn.respository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@Service
class StudentServiceTwo (@Autowired val studentRepository: StudentRepository){
    fun add(student: Student): Student {
        return studentRepository.save(student)
    }

    fun retrieveAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun retrieveStudent(id: Int): Optional<Student> {
        return studentRepository.findById(id)
    }

    fun removeStudent(id: Int) {
        return studentRepository.deleteById(id)
    }

    fun edit(student: Student): Student {
        return studentRepository.save(student)
    }


}