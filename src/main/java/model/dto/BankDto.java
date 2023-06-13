package model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BankDto {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}
