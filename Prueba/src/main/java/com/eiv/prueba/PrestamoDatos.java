package com.eiv.prueba;

import java.math.BigDecimal;


public class PrestamoDatos {
    
    BigDecimal capital;
    Integer cuotas;
    BigDecimal tna;
    
      
    
    public PrestamoDatos(BigDecimal capital, Integer cuotas, BigDecimal tna) {
        super();
        this.capital = capital;
        this.cuotas = cuotas;
        this.tna = tna;
    }
    public BigDecimal getCapital() {
        return capital;
    }
    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }
    public Integer getCuotas() {
        return cuotas;
    }
    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }
    public BigDecimal getTna() {
        return tna;
    }
    public void setTna(BigDecimal tna) {
        this.tna = tna;
    }
    @Override
    public String toString() {
        return "PrestamoDatos [capital=" + capital + ", cuotas=" + cuotas + ", tna=" + tna + "]";
    }

    
    

    
  
    
    
    

}
