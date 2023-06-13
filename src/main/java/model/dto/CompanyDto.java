package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CompanyDto {
    @JsonProperty("address")
    private AddressDto address;
    private String department;
    private String name;
    private String title;
}
