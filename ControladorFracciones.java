import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent; 
public class ControladorFracciones {

    @FXML
    private CheckBox simplificar1;

    @FXML
    private TextField txtNumF1;

    @FXML
    private TextField txtDenF1;

    @FXML
    private CheckBox simplificar2;

    @FXML
    private TextField txtNum2;

    @FXML
    private TextField txtDen2;

    @FXML
    private CheckBox simplificar3;

    @FXML
    private TextField txtNumF3;

    @FXML
    private TextField txtDenF3;

    @FXML
    private Button btnLimpiarDatos;

    @FXML
    private Button btnSumar;

    @FXML
    private Button btnRestar;

    @FXML
    private Button btnMultiplicar;

    @FXML
    private Button btnDividir;
    
    private Fraccionario fraccion1;
    private Fraccionario fraccion2;
    private Fraccionario fraccion3;
    
    public ControladorFracciones(){
        fraccion1 = new Fraccionario();
        fraccion2 = new Fraccionario();
        fraccion3 = new Fraccionario();
        
    }
    

    @FXML
    void dividir() {
        if(tomarValores()){
        try{
            tomarValores();
            Fraccionario rest  = fraccion1.dividir(fraccion2);
            responder(rest);
            
        }
        catch(Exception e){        
            desplegarError("El resultado de su división retorna 0 en el denominador.", "Error :(");
        }
    }

    }

    @FXML
    void limpiarDatos() {
        txtNumF1.setText("0");
        txtDenF1.setText("1");
        txtNum2.setText("0");
        txtDen2.setText("1");
        txtNumF3.setText("0");
        txtDenF3.setText("1");

    }

    @FXML
    void multiplicar() {
         if(tomarValores()){
          try{
            
            Fraccionario rest  = fraccion1.multiplicar(fraccion2);
            responder(rest);
            
        }
        catch(Exception e){        
            desplegarError("El resultado de su multiplicación retorna 0 en el denominador.", "Error :(");
        }
    }
    }

    @FXML
    void restar() {
         if(tomarValores()){
             try{
            
            Fraccionario rest  = fraccion1.restar(fraccion2);
            responder(rest);
            
        }
        catch(Exception e){        
            desplegarError("El resultado de la resta retorna 0 en el denominador.", "Error :(");
        }
    }

    }

    @FXML
    void sumar() {
         if(tomarValores()){
         try{
            
            Fraccionario rest  = fraccion1.sumar(fraccion2);
            responder(rest);
            
        }
        catch(Exception e){        
            desplegarError("El resultado de la suma retorna 0 en el denominador.", "Error :(");
        }
    }

    }
    public boolean tomarValores(){
        boolean pudo = false;
        
       try{         
            tomarDatos1();           
            tomarDatos2();
            pudo=true;
       } 
       catch(Exception e){        
            desplegarError("Aja", "Error :(");
        }
    return pudo;
        
    }
    public void tomarDatos1(){
        try{ 
            fraccion1.setNumerador(Integer.parseInt(txtNumF1.getText()));
            fraccion1.setDenominador(Integer.parseInt(txtDenF1.getText()));
        }
     catch(Exception e){        
            desplegarError(e.getMessage(), "Error :(");
        }
    }
     public void tomarDatos2(){
        try{ 
             fraccion2.setNumerador(Integer.parseInt(txtNum2.getText()));
             fraccion2.setDenominador(Integer.parseInt(txtDen2.getText()));
        }
        catch(Exception e){        
            desplegarError(e.getMessage(), "Error :(");
        }
    }
    public void desplegarError(String msg, String titulo ){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(titulo);

        alert.setContentText(msg);

        alert.showAndWait();
    }
    public void responder (Fraccionario resp){
      try{
          
            fraccion3.setNumerador(resp.getNumerador());
            fraccion3.setDenominador(resp.getDenominador());
            txtNumF3.setText(String.valueOf(fraccion3.getNumerador()));
            txtDenF3.setText(String.valueOf(fraccion3.getDenominador()));
            
        }
        catch(Exception e){        
            desplegarError("El resultado retorna 0 en el denominador.", "Error :(");
        }
    }
   
     @FXML
    void simplificador1(ActionEvent event) {
        tomarDatos1();
        if(simplificar1.isSelected())
        {
            
            fraccion1.simplificar();
            txtNumF1.setText(String.valueOf(fraccion1.getNumerador()));
            txtDenF1.setText(String.valueOf(fraccion1.getDenominador()));
        }
       
    }

    @FXML
    void simplificador2(ActionEvent event) {
          tomarDatos2();
          if(simplificar2.isSelected())
        {
            
            fraccion2.simplificar();
            txtNum2.setText(String.valueOf(fraccion2.getNumerador()));
            txtDen2.setText(String.valueOf(fraccion2.getDenominador()));
        }
        
    }

    @FXML
    void simplificador3(ActionEvent event) {
          if(simplificar3.isSelected())
        {
            fraccion3.simplificar();
            txtNumF3.setText(String.valueOf(fraccion3.getNumerador()));
            txtDenF3.setText(String.valueOf(fraccion3.getDenominador()));
        }
        
    }
   

}

