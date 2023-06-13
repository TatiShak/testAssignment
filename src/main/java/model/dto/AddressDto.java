package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddressDto {
    private String address;
    private String city;
    @JsonProperty("coordinates")
    private CoordinatesDto coordinates;
    private String postalCode;
    private String state;
}
