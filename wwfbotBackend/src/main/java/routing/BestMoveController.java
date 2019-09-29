package routing;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import movecalculator.MoveCalculator;

@RestController
public class BestMoveController {

    @CrossOrigin
    @PostMapping("/bestmove")
    public BestMove greeting(@RequestBody BestMoveRequestBody body) {
        BestMove bestMove = new MoveCalculator(body).getBestMove();

        return bestMove;
    }
}