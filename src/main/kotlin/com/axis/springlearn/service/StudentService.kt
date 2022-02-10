package com.axis.springlearn.service

import com.axis.springlearn.model.Student
import org.springframework.stereotype.Service
import com.axis.springlearn.exception.StudentNotFoundException

@Service
class StudentService {

    val students = mutableListOf<Student>(
        Student(1, "Raj", "Male", "raj@gmail.com", "9874561230"),
        Student(2, "Rakesh", "Male", "rakesh@gmail.com", "9874564230"),
        Student(3, "Mukesh", "Male", "mukesh@gmail.com", "9874561230")
    )

    fun findOne(id: Int): Student? {
        for (student in students) {
            if(student.id == id){
                return student
            }
        }
        throw StudentNotFoundException("Student not found")
    }

    fun findAll(): MutableList<Student> {
        return students
    }

    fun saveOrUpdate(student : Student): Boolean {
        if(findOne(student.id) != null){
            delete(student.id)
        }
        return students.add(student)
    }

    fun delete(id: Int): String? {
        for (student in students) {
            if(student.id == id){
                students.remove(student)
                return "Deleted Successfully"
            }
        }
        throw StudentNotFoundException("Student not found")
    }


}