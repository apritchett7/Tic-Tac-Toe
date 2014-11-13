import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class TicTacToe extends Application {

    private static int player = 1;

    public Button makeButton() {
        Button newButton = new Button("  ");
        newButton.setFont(new Font(50.0));
        newButton.setMinWidth(110);
        newButton.setOnAction(event -> {
            if (player % 2 == 1) {
                newButton.setText("X");
            } else {
                newButton.setText("O");
            }
            player++;
            newButton.setDisable(true);
        });
        newButton.setAlignment(Pos.CENTER);
        return newButton;
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        GridPane board = new GridPane();
        board.setHgap(15.0);
        board.setVgap(15.0);
        board.setAlignment(Pos.CENTER);
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                board.add(makeButton(), col, row);
            }
        }
        Button resetButton = new Button("Reset");
        resetButton.setAlignment(Pos.CENTER);
        resetButton.setOnAction(event -> {
            player = 1;
            ObservableList<Node> list = board.getChildren();
            for (Node myNode : list) {
                Button button = (Button) myNode;
                button.setText("  ");
                button.setDisable(false);
            }
        });
        root.getChildren().addAll(board, resetButton);

        Scene scene = new Scene(root);
        stage.setMinWidth(400);
        stage.setMinHeight(450);
        stage.setScene(scene);
        stage.setTitle("Tic-Tac-Toe!");
        stage.show();
    }
}
