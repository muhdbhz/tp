package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane; // Import FlowPane
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import seedu.address.model.listing.Listing;

import java.util.Comparator;

/**
 * An UI component that displays information of a {@code Listing}.
 */
public class ListingCard extends UiPart<Region> {
    private static final String FXML = "ListingListCard.fxml";

    public final Listing listing;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label price;
    @FXML
    private Label area;
    @FXML
    private Label region;
    @FXML
    private FlowPane buyers; // Change from VBox to FlowPane
    @FXML
    private Label address;
    @FXML
    private Label seller;
    @FXML
    private Line underline;

    public ListingCard(Listing listing, int displayedIndex) {
        super(FXML);
        this.listing = listing;
        id.setText(displayedIndex + ". ");
        initializeName();
        initializeUnderline();
        initializePrice();
        initializeArea();
        initializeRegion();
        initializeAddress();
        initializeSeller();
        initializeBuyers();
//        testLongBuyerList();
    }

    private void initializeName() {
        name.setText(listing.getName().fullName);
    }

    private void initializeUnderline() {
        // Bind underline width to name label with adjustment
        underline.endXProperty().bind(name.widthProperty().add(45));
    }

    private void initializePrice() {
        price.setText(String.format("$%s", listing.getPrice().toString()));
    }

    private void initializeArea() {
        area.setText(String.format("%s m²", listing.getArea().toString()));
    }

    private void initializeRegion() {
        region.setText(listing.getRegion().toString());

        String existingStyle = region.getStyle();
        String newBackgroundColor = "-fx-background-color: " + listing.getRegion().getColor() + ";";
        region.setStyle(existingStyle + newBackgroundColor);
    }

    private void initializeAddress() {
        address.setText(listing.getAddress().toString());
    }

    private void initializeSeller() {
        seller.setText(listing.getSeller().getName().fullName);
    }

    private void initializeBuyers() {
        listing.getBuyers().stream()
                .sorted(Comparator.comparing(buyer -> buyer.getName().fullName))
                .forEach(buyer -> {
                    Label buyerLabel = new Label(buyer.getName().fullName);
                    buyers.getChildren().add(buyerLabel);
                });
    }

    private void testLongBuyerList() {
        // Create a list of buyer names for testing
        String[] testBuyerNames = {
                "Alex Yeoh", "Charlotte Oliveiro", "David Tan", "Emily Wong", "Fiona Lim",
                "George Ho", "Hannah Lee", "Ian Chen", "Jane Smith", "Kevin Tan",
                "Lily Wu", "Michael Koh", "Nina Yu", "Oscar Ong", "Pauline Ng",
                "Quinn Lim", "Ryan Chua", "Samantha Tan", "Thomas Lim", "Ursula Lee"
        };

        StringBuilder buyerNames = new StringBuilder();

        for (int i = 0; i < testBuyerNames.length; i++) {
            if (!buyerNames.isEmpty()) {
                buyerNames.append(", "); // Append a comma if there are existing names
            }
            buyerNames.append(testBuyerNames[i]); // Append buyer name
        }

        // Create a label for the concatenated names and add it to the buyers FlowPane
        Label buyersLabel = new Label(buyerNames.toString());
        buyers.getChildren().add(buyersLabel);
    }


    // Getter methods for private fields
    public Label getId() {
        return id;
    }

    public Label getName() {
        return name;
    }

    public Label getPrice() {
        return price;
    }

    public Label getArea() {
        return area;
    }

    public Label getRegion() {
        return region;
    }

    public Label getAddress() {
        return address;
    }

    public Label getSeller() {
        return seller;
    }
}
