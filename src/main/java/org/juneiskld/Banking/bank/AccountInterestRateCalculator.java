package org.juneiskld.Banking.bank;

import java.math.BigDecimal;

public interface AccountInterestRateCalculator {

    /**
     * Calculate the interest based on the account balance.
     *
     * @param balance the balance of the account
     * @return the calculated interes
     */

    BigDecimal calculateInterest(BigDecimal balance);
}
