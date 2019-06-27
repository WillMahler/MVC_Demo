import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AppController extends Application {

    private AppView  view;
    private AppModel model;

    // Start is essentially the constructor for the application
    public void start(Stage primaryStage) {

        System.out.println("CONTROLLER: start() called");

        Pane appWindow = new Pane();
        view = new AppView();

        // Add the view to the pane that we will use to set the scene below
        appWindow.getChildren().addAll(view);

        model = new AppModel();
        view.update(model);

        // Set the stage and open the window
        primaryStage.setTitle("An App");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(appWindow));
        primaryStage.show();

        // **EVENT HANDLERS**
        // Handle pressing the view's button
        view.getAddToRevenueButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("CONTROLLER: **Button Pressed** event handler triggered");
                model.addToRevenue();
                model.removeFromEmojiStock(view.getEmojiListView().getSelectionModel().getSelectedIndex());
                view.update(model);
            }
        });

        // Handle clicking within the view's listview
        view.getEmojiListView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("CONTROLLER: **ListView Pressed** event handler triggered");
                view.update(model);
            }
        });

    }

}
