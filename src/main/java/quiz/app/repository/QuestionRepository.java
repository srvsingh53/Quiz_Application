package quiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.app.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
