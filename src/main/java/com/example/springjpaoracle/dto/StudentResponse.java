package com.example.springjpaoracle.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.springjpaoracle.model.Student;

public class StudentResponse
{
    private String name;
    private List<CourseResponse> courses;
    private String socialSecurityNumber;

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static StudentResponse from(Student student)
    {
        final StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(student.getName());
        studentResponse.setSocialSecurityNumber(student.getSocialSecurityNumber());
        studentResponse.setCourses(student.getCourses().stream()
            .map(CourseResponse::from)
            .collect(Collectors.toList()));

        return studentResponse;
    }

    public List<CourseResponse> getCourses()
    {
        return courses;
    }

    public void setCourses(final List<CourseResponse> courses)
    {
        this.courses = courses;
    }

    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(final String socialSecurityNumber)
    {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}
