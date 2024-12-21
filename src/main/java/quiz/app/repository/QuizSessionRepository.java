package quiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.app.Model.QuizSession;

import java.util.Optional;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {
    Optional<QuizSession> findByUserId(Long userId);
}
