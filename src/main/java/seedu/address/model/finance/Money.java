package seedu.address.model.finance;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Money {
    private BigDecimal amount;
    public static final String VALIDATION_REGEX = "\\d*.\\d{1,2}?";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.00");
    public static final String MESSAGE_CONSTRAINTS = "Money should only contain numeric characters and should not be blank";

    public Money(BigDecimal amount) {
        requireNonNull(amount);
        checkArgument(isValidAmount(amount.toString()), MESSAGE_CONSTRAINTS);
        this.amount = amount;
    }

    public Money(String amount) {
        requireNonNull(amount);
        checkArgument(isValidAmount(amount), MESSAGE_CONSTRAINTS);
        this.amount = new BigDecimal(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Return is a string is a valid money amount.
     */
    public static boolean isValidAmount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return DECIMAL_FORMAT.format(amount);
    }
}