package application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PaymentMethodResultItem {
    public UUID id;
    public String name;

    public PaymentMethodResultItem(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
