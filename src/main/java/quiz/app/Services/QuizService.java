package quiz.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.app.Model.Question;
import quiz.app.Model.QuizSession;
import quiz.app.repository.QuestionRepository;
import quiz.app.repository.QuizSessionRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startNewSession(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        return quizSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public String submitAnswer(Long userId, Long questionId, String selectedOption) {
        Optional<Question> questionOpt = questionRepository.findById(questionId);
        Optional<QuizSession> sessionOpt = quizSessionRepository.findByUserId(userId);

        if (questionOpt.isEmpty() || sessionOpt.isEmpty()) {
            return "Invalid Question or Session.";
        }

        Question question = questionOpt.get();
        QuizSession session = sessionOpt.get();

        session.setTotalQuestions(session.getTotalQuestions() + 1);
        if (question.getCorrectOption().equals(selectedOption)) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
            quizSessionRepository.save(session);
            return "Correct Answer!";
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
            quizSessionRepository.save(session);
            return "Incorrect Answer.";
        }
    }

    public QuizSession getSummary(Long userId) {
        return quizSessionRepository.findByUserId(userId).orElse(null);
    }
}
