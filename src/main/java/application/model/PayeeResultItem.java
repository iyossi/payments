package application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PayeeResultItem {
    public UUID id;
    public String name;

    public PayeeResultItem(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
