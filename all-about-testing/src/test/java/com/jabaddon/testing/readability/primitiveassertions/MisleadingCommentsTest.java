package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MisleadingCommentsTest {
    private TimeService timeService;

    @Test
    public void pastDueDateDebtFlagsAccountNotInGoodStandingBad() {
        // create a basic account
        Customer customer = new Customer();
        Account account = new CorporateAccount(customer);

        // register a debt that has a due date in the future
        account.add(new Liability(customer, new Money("MXN", 1000), timeService.fromNow(30, TimeUnit.DAYS)));

        // account should still be ingood standing
        assertThat(account.inGoodStanding(), is(true));

        // fast-forward past the due date
        timeService.moveForward(30, TimeUnit.DAYS);

        // account shouldn't be in good standing anymore
        assertThat(account.inGoodStanding(), is(false));
    }

    @Test
    public void pastDueDateDebtFlagsAccountNotInGoodStanding() {
        Customer customer = new Customer();
        Account corporateAccount = new CorporateAccount(customer);

        int dueDaysFromNow = 30;
        addDebtWithDueDateInFuture(customer, corporateAccount, dueDaysFromNow);

        assertThat(corporateAccount.inGoodStanding(), is(true));

        moveForwardTime(dueDaysFromNow + 1);

        assertThat(corporateAccount.inGoodStanding(), is(false));
    }

    private void moveForwardTime(int dueDaysFromNow) {
        timeService.moveForward(dueDaysFromNow, TimeUnit.DAYS);
    }

    private void addDebtWithDueDateInFuture(Customer customer, Account corporateAccount, int dueDaysFromNow) {
        corporateAccount.add(new Liability(customer, new Money("MXN", 1000), timeService.fromNow(dueDaysFromNow, TimeUnit.DAYS)));
    }
}
