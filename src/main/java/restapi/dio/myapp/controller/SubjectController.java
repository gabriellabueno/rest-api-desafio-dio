package restapi.dio.myapp.controller;

import org.springframework.web.bind.annotation.*;
import restapi.dio.myapp.model.Subject;
import restapi.dio.myapp.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("/{subjectId}")
    public Subject getSubjectById(@PathVariable String subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}")
    public Subject updateSubject(@PathVariable String subjectId, @RequestBody Subject subject) {
        return subjectService.updateSubject(subjectId, subject);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable String subjectId) {
        subjectService.deleteSubject(subjectId);
    }

}
