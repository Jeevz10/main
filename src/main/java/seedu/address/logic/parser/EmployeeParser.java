package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddEventCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteEventCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditEventCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.FindEventCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.InviteCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.LoginCommand;
import seedu.address.logic.commands.LogoutCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.RemoveCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.ShowMineCommand;
import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.parser.exceptions.InvalidLoginException;
import seedu.address.logic.parser.exceptions.InvalidPrivilegeException;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses user input.
 */
public class EmployeeParser extends CommandsParser {

    public static final String IDENTITY = "Employee";

    private static String LOGIN_IDENTITY;

    public EmployeeParser() {
        LOGIN_IDENTITY = null;
    }

    public EmployeeParser(String loginidentity) {
        this.LOGIN_IDENTITY = loginidentity;
    }

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case SelectCommand.COMMAND_WORD:
            return new SelectCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case FindEventCommand.COMMAND_WORD:
            return new FindEventCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommandParser().parse(arguments);

        case SortCommand.COMMAND_WORD:
            return new SortCommandParser().parse(arguments);

        case InviteCommand.COMMAND_WORD:
            return new InviteCommandParser().parse(arguments);

        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        case LoginCommand.COMMAND_WORD:
            throw new InvalidLoginException(IDENTITY);

        case LogoutCommand.COMMAND_WORD:
            return new LogoutCommandParser().parse(commandWord);

        case AddCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case AddEventCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case EditCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case EditEventCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case DeleteCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case DeleteEventCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case RemoveCommand.COMMAND_WORD:
            throw new InvalidPrivilegeException(IDENTITY);

        case ShowMineCommand.COMMAND_WORD:
            return new ShowMineCommandParser().parse(LOGIN_IDENTITY);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    public String getIdentity() {
        return this.IDENTITY;
    }

}
