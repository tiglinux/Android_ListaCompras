/*
        Created by : Tiago Ribeiro Santos
        email : tiago.programador@hotmail.com

 */
package com.tiagoribeirosantos.listadecompras;

public class Produto {
    private float preco;
    private String productName;
    private boolean urgent;

    public Produto(float preco, String productName, boolean urgent) {
        this.setPreco(preco);
        this.setProductName(productName);
        this.setUrgent(urgent);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}
