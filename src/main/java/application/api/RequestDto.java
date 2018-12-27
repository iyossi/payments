package application.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private float amount;
    private Currency currency;
    private UUID userId;
    private UUID payeeId;
    private UUID paymentMethod;
};
