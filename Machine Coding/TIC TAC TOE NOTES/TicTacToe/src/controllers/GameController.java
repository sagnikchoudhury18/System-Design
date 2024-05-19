package controllers;

import models.Game;
import models.GameState;
import models.Player;
import services.GamesService;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {

    Game game;
    GamesService gamesService;

    public GameController(Game game){
        this.game = game;
        this.gamesService = new GamesService(game);
    }

    public static Game initiateGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return  new Game(dimension, players, winningStrategies);
    }

    public void  startGame() {
        game.setGameState(GameState.IN_PROGRESS);
        gamesService.executeNextMoves();
    }
}
