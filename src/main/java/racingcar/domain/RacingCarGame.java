package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.dto.RacingCarResult;

public class RacingCarGame {

    private final Cars cars;
    private final AttemptNumber attemptNumber;
    private final NumberGenerator numberGenerator;

    public RacingCarGame(final Cars cars, final AttemptNumber attemptNumber, final NumberGenerator numberGenerator) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.numberGenerator = numberGenerator;
    }

    public RacingCarGame(final List<String> names, final int attempt, final NumberGenerator numberGenerator) {
        this.cars = Cars.from(names);
        this.attemptNumber = new AttemptNumber(attempt);
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        while (attemptNumber.isRemain()) {
            attemptNumber.decrease();
            cars.moveAll(numberGenerator);
        }
    }

    public RacingCarResult getResult() {
        List<String> winners = findWinners();
        return new RacingCarResult(winners, cars.getCars(), attemptNumber.getAttemptNumber());
    }

    private List<String> findWinners() {
        final Cars winners = cars.findWinners();
        return getWinnerNames(winners);
    }

    private List<String> getWinnerNames(final Cars winners) {
        return winners.getCars().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
