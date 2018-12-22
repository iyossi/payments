package application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    public float amount;
    public Currency currency;
    public UUID userId;
    public UUID payeeId;
    public UUID paymentMethod;
};
