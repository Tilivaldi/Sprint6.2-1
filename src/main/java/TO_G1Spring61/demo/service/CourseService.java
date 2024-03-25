package TO_G1Spring61.demo.service;

import TO_G1Spring61.demo.model.Course;
import TO_G1Spring61.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourse() {
        return courseRepository.findAll();
    }
}
