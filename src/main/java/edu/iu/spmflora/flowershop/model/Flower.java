package edu.iu.spmflora.flowershop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(schema = "flowershop", name = "flowers")
public class Flower {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float cost;
    private boolean md, bd, ty;
    private boolean mixed;
    private boolean red;
    private boolean yellow;

    public void setMd(boolean md) {
        this.md = md;
    }

    public void setBd(boolean bd) {
        this.bd = bd;
    }

    public void setTy(boolean ty) {
        this.ty = ty;
    }

    public void setMixed(boolean mixed) {
        this.mixed = mixed;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public void setOrange(boolean orange) {
        this.orange = orange;
    }

    private boolean green;
    private boolean orange;

    public Flower() {
    }

    public Flower(int id, String name, float cost, String colors, String category){
        this.id = id;
        this.name = name;
        this.cost = cost;

        colors = colors.toLowerCase();
        if(colors.contains("mixed")){
            mixed = true;
        }
        if(colors.contains("red")){
            red = true;
        }
        if(colors.contains("yellow")){
            yellow = true;
        }
        if(colors.contains("green")){
            green = true;
        }
        if(colors.contains("orange")){
            orange = true;
        }

        category = category.toLowerCase();
        if(category.contains("mother's day")){
            md = true;
        }
        if(category.contains("birthday")){
            bd = true;
        }
        if(category.contains("thank you")){
            ty = true;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getColor(){
        String response = "";
        if(mixed){
            response += "mixed, ";
        }
        if(red){
            response += "red, ";
        }
        if(yellow){
            response += "yellow, ";
        }
        if(green){
            response += "green, ";
        }
        if(orange){
            response += "orange, ";
        }
        return response;
    }

    public String getCategory(){
        String response = "";
        if(md){
            response += "Mother's Day, ";
        }
        if(bd){
            response += "Birthday, ";
        }
        if(ty){
            response += "Thank You, ";
        }
        return response;
    }

    public void setColor(String colors){
        colors = colors.toLowerCase();
        if(colors.contains("mixed")){
            mixed = true;
        }
        if(colors.contains("red")){
            red = true;
        }
        if(colors.contains("yellow")){
            yellow = true;
        }
        if(colors.contains("green")){
            green = true;
        }
        if(colors.contains("orange")){
            orange = true;
        }

    }

    public void setCategory(String categories){
        categories = categories.toLowerCase();
        if(categories.contains("mother's day")){
            md = true;
        }
        if(categories.contains("birthday")){
            bd = true;
        }
        if(categories.contains("thank you")){
            ty = true;
        }
    }



}
