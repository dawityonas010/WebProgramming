package com.schoolsystem.project.repositories;

import com.schoolsystem.project.domains.*;

public interface TeacherRepository {
	Iterable<Teacher> findAll();

	Iterable<Teacher> findByClass(ClassRoom classRoom);

	Teacher findById(String id);

	Teacher save(Teacher teacher);

	Iterable<Teacher> findByCourse(Subject subject);
}
