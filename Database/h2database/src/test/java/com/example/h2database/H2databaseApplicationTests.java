package com.example.h2database;

import com.example.h2database.entity.Course;
import com.example.h2database.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class H2databaseApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void givenDatasourceAvailable() throws SQLException {
        assertThat(dataSource.getClass().getName()).isEqualTo("com.zaxxer.hikari.HikariDataSource");
        assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).isEqualTo("H2");
    }

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse() {
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
        Course savedCourse = courseRepository.save(course);
        assertThat(courseRepository.findById(savedCourse.getId()).get()).isEqualTo(course);
    }

    @Test
    public void givenUpdateCourseWhenLoadTheCourseThenExpectUpdatedCourse() {
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
        courseRepository.save(course);
        course.setRating(5);
        Course savedCourse = courseRepository.save(course);
        assertThat(courseRepository.findById(savedCourse.getId()).get().getRating()).isEqualTo(5);
    }

    @Test
    public void givenDeleteCourseWhenLoadTheCourseThenExpectNoCourse() {
        Course course = new Course("Rapid Spring Boot Application Development", "Spring", 4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
        Course savedCourse  = courseRepository.save(course);
        System.out.println(savedCourse.getId());
        assertThat(courseRepository.findById(savedCourse.getId()).get()).isEqualTo(course);
        courseRepository.delete(course);
        assertThat(courseRepository.findById(savedCourse.getId()).isPresent()).isFalse();
    }

}
