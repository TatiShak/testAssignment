package model.dto;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CartDto {
    private int id;
    private List<ProductDto> productDtos;
    private int total;
    private int discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;
}
