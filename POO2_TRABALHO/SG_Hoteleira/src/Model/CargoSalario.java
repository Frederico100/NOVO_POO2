package Model;

import DAO.CargoSalarioDAO;
import java.util.ArrayList;

public class CargoSalario {
    private int codigo_cargo;
    private double salario;
    private String cargo;

    public CargoSalario(double salario, String cargo) {
        this.salario = salario;
        this.cargo = cargo;
    }

    public CargoSalario(){
        
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCodigo_cargo() {
        return codigo_cargo;
    }

    public void setCodigo_cargo(int codigo_cargo) {
        this.codigo_cargo = codigo_cargo;
    }
    
    public void add(CargoSalario cargoSalario){
        new CargoSalarioDAO().insert(cargoSalario);
    }
    public ArrayList<CargoSalario> consult(){
       return new CargoSalarioDAO().select();
    }
    
    public void update(CargoSalario cargoSalario){
        new CargoSalarioDAO().Update(cargoSalario);
    }
    
    public void delete(CargoSalario cargoSalario){
        new CargoSalarioDAO().delete(cargoSalario);
    }

}