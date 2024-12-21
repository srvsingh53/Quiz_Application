package quiz.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quiz.app.Model.Question;
import quiz.app.Model.QuizSession;
import quiz.app.Services.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startNewSession(@RequestParam Long userId) {
        return ResponseEntity.ok(quizService.startNewSession(userId));
    }

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(
            @RequestParam Long userId,
            @RequestParam Long questionId,
            @RequestParam String selectedOption
    ) {
        return ResponseEntity.ok(quizService.submitAnswer(userId, questionId, selectedOption));
    }

    @GetMapping("/summary")
    public ResponseEntity<QuizSession> getSummary(@RequestParam Long userId) {
        return ResponseEntity.ok(quizService.getSummary(userId));
    }
}
