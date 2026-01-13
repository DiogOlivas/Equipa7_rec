package com.upt.lp.Equipa7.DTO;


public class TransactionDTO {
    private Long id;
    private double value;
    private String date;
    private String description;
    private String paymentMethod; 
    private String category;
    

    public TransactionDTO() {}

    public TransactionDTO(Long id, double value, String date, String description, String paymentMethod, String category) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.category = category;
    }
    //
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public double getValue(){
        return value;
    }
    public void setValue(double value){
        this.value = value;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getPaymentMethod(){
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}
