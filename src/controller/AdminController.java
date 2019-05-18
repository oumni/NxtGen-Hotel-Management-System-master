package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;

import dao.AdminDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.AdminModel;

public class AdminController implements Initializable {

    @FXML
    private AnchorPane mainhomepane;

    @FXML
    private AnchorPane leftpane;

    @FXML
    private JFXButton addbtn;

    @FXML
    private JFXButton moviescreensbtn;

    @FXML
    private JFXButton logoutbtn;

    @FXML
    private Label userlabel;

    @FXML
    private JFXButton moviescreensbtn1;

    @FXML
    private AnchorPane toppane;

    @FXML
    private JFXButton minimisebtn;

    @FXML
    private JFXButton closebtn;

    @FXML
    private JFXTabPane tabpane;

    @FXML
    private AnchorPane s3tile1;

    @FXML
    private Label s3availableseats;

    @FXML
    private AnchorPane s3tile4;

    @FXML
    private Label s3timeremaining;

    @FXML
    private AnchorPane s3tile2;

    @FXML
    private Label s3repeatsleft;

    @FXML
    private AnchorPane s3tile5;

    @FXML
    private Label s3timeslot;

    @FXML
    private AnchorPane s3tile3;

    @FXML
    private Label s3rating;

    @FXML
    private AnchorPane s3tile6;

    @FXML
    private TableView<AdminModel> tableView;

    @FXML
    private TableColumn<AdminModel,String> col_id;

    @FXML
    private TableColumn<AdminModel,String> col_login;

    @FXML
    private TableColumn<AdminModel,String> col_prenom;

    @FXML
    private TableColumn<AdminModel,String> col_nom;

    @FXML
    private TableColumn<AdminModel,String> col_email;

    @FXML
    private TableColumn<AdminModel,String> col_date;

    @FXML
    private AnchorPane p1;

    @FXML
    private AnchorPane p1shadow;

    @FXML
    private AnchorPane p2;

    @FXML
    private AnchorPane p2shadow;

    @FXML
    private AnchorPane p3;

    @FXML
    private AnchorPane p3shadow;

    @FXML
    private Label datelabel;

    @FXML
    private Label timelabel;

    @FXML
    void btnExit(MouseEvent event) {

    }

    @FXML
    void btnHover(MouseEvent event) {

    }

    @FXML
    void handleClose(ActionEvent event) {

    }

    public TableColumn<?, ?> getCol_id() {
		return col_id;
	}

	public void setCol_id(TableColumn<AdminModel, String> col_id) {
		this.col_id = col_id;
	}

	public TableColumn<?, ?> getCol_login() {
		return col_login;
	}

	public void setCol_login(TableColumn<AdminModel, String> col_login) {
		this.col_login = col_login;
	}

	public TableColumn<?, ?> getCol_prenom() {
		return col_prenom;
	}

	public void setCol_prenom(TableColumn<AdminModel, String> col_prenom) {
		this.col_prenom = col_prenom;
	}

	public TableColumn<?, ?> getCol_nom() {
		return col_nom;
	}

	public void setCol_nom(TableColumn<AdminModel, String> col_nom) {
		this.col_nom = col_nom;
	}

	public TableColumn<?, ?> getCol_email() {
		return col_email;
	}

	public void setCol_email(TableColumn<AdminModel, String> col_email) {
		this.col_email = col_email;
	}

	public TableColumn<?, ?> getCol_date() {
		return col_date;
	}

	public void setCol_date(TableColumn<AdminModel, String> col_date) {
		this.col_date = col_date;
	}

	@FXML
    void loadScene(ActionEvent event) {

    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void minimiseWindow(ActionEvent event) {

    }

    @FXML
    void rotatePane(MouseEvent event) {

    }

    @FXML
    void tileExit(MouseEvent event) {

    }

    @FXML
    void tileHover(MouseEvent event) {

    }

    @FXML
    void viewMovieScreens(MouseEvent event) {

    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		AdminDao dao = new AdminDao();
		ObservableList<AdminModel> liste = dao.AfficherUtilisateurs();
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
		col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		tableView.setItems(liste);

	}

}
