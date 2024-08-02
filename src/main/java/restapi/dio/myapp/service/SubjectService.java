package restapi.dio.myapp.service;

import restapi.dio.myapp.exception.ResourceNotFoundException;
import restapi.dio.myapp.model.Subject;
import restapi.dio.myapp.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(String subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        if(subject.isPresent()) {
            return subject.get();
        } else {
            throw new ResourceNotFoundException("Resource with id = " + subjectId + " was not found!");
        }
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(String subjectId, Subject updatedSubject) {
        Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);

        if(subjectOptional.isPresent()) {
            Subject existingSubject = subjectOptional.get();
            existingSubject.setSubjectName(updatedSubject.getSubjectName());
            existingSubject.setSubjectProfessor(updatedSubject.getSubjectProfessor());
            existingSubject.setSubjectSemester(updatedSubject.getSubjectSemester());
            return subjectRepository.save(existingSubject);
        } else {
            throw new ResourceNotFoundException("Record with id = " + subjectId + " was not found");
        }
    }

    public void deleteSubject(String subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        if (subject.isPresent()) {
            subjectRepository.deleteById(subjectId);
        } else {
            throw new ResourceNotFoundException("Record with id = " + subjectId + " was not found");
        }
    }
}
