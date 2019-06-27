import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class AppView extends Pane {

    private Button addToRevenueButton;
    private Label revenueLabel;
    private TextField revenueTextField;
    private ListView<String> emojiListView;

    // Getters
    public Button getAddToRevenueButton()       {return addToRevenueButton;}
    public ListView<String> getEmojiListView()  { return emojiListView; }

    // Constructor
    public AppView() {

        addToRevenueButton = new Button("Add 1 To Revenue");
        addToRevenueButton.setStyle("-fx-font: 14 arial;");
        addToRevenueButton.relocate(34, 345);
        addToRevenueButton.setPrefSize(140, 50);


        revenueLabel = new Label("Revenue:");
        revenueLabel.relocate(25, 90);
        revenueLabel.setStyle("-fx-font: 14 arial;");

        revenueTextField = new TextField();
        revenueTextField.relocate(90, 84);
        revenueTextField.setPrefSize(100, 30);

        emojiListView = new ListView<String>();
        emojiListView.relocate(210, 50);
        emojiListView.setPrefSize(280, 290);


        getChildren().addAll(addToRevenueButton, revenueLabel, revenueTextField, emojiListView);
        setPrefSize(800, 400);

    }

    public void update(AppModel aModel){

        System.out.println("    VIEW: ~~Update Called~~");
        System.out.println("    VIEW:   updating the revenue textbox to model.getRevenue()...");

        revenueTextField.setText("" + aModel.getRevenue());

        System.out.println("    VIEW:   updating the ListView to model.getStock()...");

        emojiListView.setItems(FXCollections.observableArrayList(aModel.getEmojiStock()));


        System.out.println("    VIEW:   enabling/disabling the button...");
        // This line below sets whether button is enabled or disabled based on
        // whether anything is selected in the ListView
        addToRevenueButton.setDisable(emojiListView.getSelectionModel().getSelectedIndex() <0);


        System.out.println("    VIEW: ~~Update Complete~~");

    }

}
