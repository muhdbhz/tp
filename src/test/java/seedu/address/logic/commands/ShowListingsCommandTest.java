package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalListings.getTypicalListings;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Listings;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ShowListingsCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), getTypicalListings());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), model.getListings());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ShowListingsCommand(), model,
                ShowListingsCommand.MESSAGE_SUCCESS, expectedModel);
    }

//    @Test
//    public void execute_listIsFiltered_showsEverything() {
//        showPersonAtIndex(model, INDEX_FIRST_PERSON);
//        assertCommandSuccess(new ShowListingsCommand(), model,
//                ShowListingsCommand.MESSAGE_SUCCESS, expectedModel);
//    }
}
