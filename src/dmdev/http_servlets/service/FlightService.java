package dmdev.http_servlets.service;

import dmdev.http_servlets.dao.FlightDao;
import dmdev.http_servlets.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FlightService {

    public static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder()
                        .id(flight.getId())
                        .description(
                                "%s - %s - %s".formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus())
                        )
                        .build()
                )
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
