package strategies.botplaying;

import models.DifficultyLevel;

public class BotPlayingStrategyFactory {
    //private static final EasyBotPlayingStrategy easyStrategy = new EasyBotPlayingStrategy();

    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
            case HARD:
                return new HardBotPlayingStrategy();
        }
        return null;
    }

    private BotPlayingStrategyFactory() {}

}
