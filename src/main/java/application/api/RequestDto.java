package application.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestDto {
    private float amount;
    private Currency currency;
    private UUID userId;
    private UUID payeeId;
    private UUID paymentMethodId;

    @Override
    public String toString() {
        return "RequestDto{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", userId=" + userId +
                ", payeeId=" + payeeId +
                ", paymentMethodId=" + paymentMethodId +
                '}';
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
    }

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public RequestDto(float amount, Currency currency, UUID userId, UUID payeeId, UUID paymentMethod) {
        this.amount = amount;
        this.currency = currency;
        this.userId = userId;
        this.payeeId = payeeId;
        this.paymentMethodId = paymentMethod;
    }
};
