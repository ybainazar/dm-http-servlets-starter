package dmdev.http_servlets.dto;

import lombok.*;

//@Value // all fields are made private and final by default, and setters are not generated -> @Data + finals
//@Data //  @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations
//@AllArgsConstructor
//@Getter
//@EqualsAndHashCode
//@ToString
@Value
@Builder
public class FlightDto {
    Long id;
    String description;
}


//public class FlightDto {
//    private final Long id;
//    private final String description;
//
//    public FlightDto(Long id, String description) {
//        this.id = id;
//        this.description = description;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FlightDto flightDto = (FlightDto) o;
//        return Objects.equals(id, flightDto.id) && Objects.equals(description, flightDto.description);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, description);
//    }
//
//    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("FlightDto{");
//        sb.append("id=").append(id);
//        sb.append(", description='").append(description).append('\'');
//        sb.append('}');
//        return sb.toString();
//    }
//}
