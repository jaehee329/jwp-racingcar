package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.NumberGenerator;

public class RacingCarGame {

    private final Cars cars;
    private final AttemptNumber attemptNumber;
    private final NumberGenerator numberGenerator;

    public RacingCarGame(final Cars cars, final AttemptNumber attemptNumber, final NumberGenerator numberGenerator) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.numberGenerator = numberGenerator;
    }

    public List<String> findWinners() {
        play();
        final Cars winners = cars.findWinners();
        return getWinnerNames(winners);
    }

    private void play() {
        while (attemptNumber.isRemain()) {
            attemptNumber.decrease();
            cars.moveAll(numberGenerator);
        }
    }

    private List<String> getWinnerNames(final Cars winners) {
        return winners.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Cars getCars() {
        return cars;
    }

    public AttemptNumber getAttemptNumber() {
        return attemptNumber;
    }
}