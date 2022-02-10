package com.axis.springlearn.respository

import com.axis.springlearn.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student,Int>{

}