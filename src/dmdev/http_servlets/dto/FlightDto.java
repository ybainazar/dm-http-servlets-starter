package dmdev.http_servlets.dto;

import lombok.*;

@Value // all fields are made private and final by default, and setters are not generated -> @Data + finals
//@Data //  @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations
//@AllArgsConstructor
//@Getter
//@EqualsAndHashCode
//@ToString
@Builder
public class FlightDto {
    Long id;
    String description;
}
