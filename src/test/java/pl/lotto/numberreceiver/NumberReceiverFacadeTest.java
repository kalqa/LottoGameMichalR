package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberReceiverFacadeTest {

    @Test
    public void should_return_client_lottery_id() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(
                new NumberValidator(),
                LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.clientLotteryId()).isPresent();
    }

    @Test
    public void should_return_draw_date() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.drawDate()).isPresent();
    }

    @Test
    public void should_return_draw_date_for_next_saturday() {
        // given
        LocalDateTime currentDate = LocalDateTime.of(2022, 8, 3, 18, 34);
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), currentDate);
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.drawDate()).isPresent();
        assertThat(result.drawDate().get()).isEqualTo(LocalDateTime.of(2022, 8, 6, 12, 0));
    }

    @Test
    public void should_return_correct_message() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("everything is OK");
    }

    @Test
    public void should_return_numbers_in_correct_range() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 100);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("numbers out of range");
    }

    @Test
    public void should_return_correct_number_of_numbers() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("to many numbers");
    }

    @Test
    public void should_return_failed_message_when_user_gave_duplicate_numbers() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("the numbers are not different");
    }

    @Test
    public void should_return_zero_number() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList();
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("you didn't provide numbers");
    }

    @Test
    public void should_return_too_few_numbers_were_given() {
        // given
        NumberReceiverFacade facade = new NumberReceiverFacade(new NumberValidator(), LocalDateTime.of(2022, 7, 2, 11, 0));
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3);
        // when
        NumberReceiverResultDto result = facade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("too few numbers");
    }
}
