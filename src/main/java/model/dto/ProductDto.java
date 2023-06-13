package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProductDto {
    private int id;
    private String title;
    private double price;
    private double rating;
    private String description;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private List<String> images;
    @JsonProperty("discountPercentage")
    private double discountPercentage;
}
