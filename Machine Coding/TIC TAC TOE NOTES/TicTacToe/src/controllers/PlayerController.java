package controllers;

import models.*;
import strategies.botplaying.BotPlayingStrategyFactory;

public class PlayerController {

    public static Player createHumanPlayer(String name, int age, char symbol) {
        return HumanPlayer.builder()
                .age(age)
                .playerType(PlayerType.HUMAN)
                .name(name)
                .symbol(symbol)
                .build();
    }

    public static Player createBot(String name, char symbol, DifficultyLevel difficultyLevel) {
        return BotPlayer.builder()
                .name(name)
                .symbol(symbol)
                .playerType(PlayerType.BOT)
                .difficultyLevel(difficultyLevel)
                .botPlayingStrategy(BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel))
                .build();
    }

}
