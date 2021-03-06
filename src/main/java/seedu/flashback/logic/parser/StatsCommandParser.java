package seedu.flashback.logic.parser;

import static seedu.flashback.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Optional;

import seedu.flashback.commons.core.index.Index;
import seedu.flashback.logic.commands.StatsCommand;
import seedu.flashback.logic.parser.exceptions.ParseException;

public class StatsCommandParser implements Parser<StatsCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the StatsCommand
     * and returns a StatsCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public StatsCommand parse(String args) throws ParseException {
        try {
            Optional<Index> cardIndex = Optional.empty();
            if (!args.isBlank()) {
                cardIndex = Optional.of(ParserUtil.parseIndex(args));
            }
            return new StatsCommand(cardIndex);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, StatsCommand.MESSAGE_USAGE), pe);
        }
    }
}
