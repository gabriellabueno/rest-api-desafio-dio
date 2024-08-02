package restapi.dio.myapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import restapi.dio.myapp.model.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {

}
