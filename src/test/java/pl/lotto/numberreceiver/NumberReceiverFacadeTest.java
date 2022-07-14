package pl.lotto.numberreceiver;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class NumberReceiverFacadeTest {

    @Test
    public void should_return_client_lottery_id() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.clientLotteryId()).isPresent();
    }

    @Test
    public void should_return_draw_date() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.drawDate()).isPresent();
    }

}
