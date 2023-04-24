package racingcar.domain.dto;

import java.util.List;

import racingcar.domain.Car;

public class RacingCarResultDto {

    private final List<String> winners;
    private final List<Car> cars;
    private final Integer attempt;

    public RacingCarResultDto(final List<String> winners, final List<Car> cars, final Integer attempt) {
        this.winners = winners;
        this.cars = cars;
        this.attempt = attempt;
    }

    public RacingCarResultDto(final List<String> winners, final List<Car> cars) {
        this(winners, cars, null);
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempt() {
        return attempt;
    }
}