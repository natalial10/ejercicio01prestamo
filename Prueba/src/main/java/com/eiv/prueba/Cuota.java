package com.eiv.prueba;
import java.math.BigDecimal;


public class Cuota {
    
    Integer cuotas;
    BigDecimal capital;
    BigDecimal interes;
    BigDecimal saldo;
    
    public Cuota(Integer cuotas, BigDecimal capital, BigDecimal interes, BigDecimal saldo) {
        super();
        this.cuotas = cuotas;
        this.capital = capital;
        this.interes = interes;
        this.saldo = saldo;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((capital == null) ? 0 : capital.hashCode());
        result = prime * result + ((cuotas == null) ? 0 : cuotas.hashCode());
        result = prime * result + ((interes == null) ? 0 : interes.hashCode());
        result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cuota other = (Cuota) obj;
        if (capital == null) {
            if (other.capital != null)
                return false;
        } else if (!capital.equals(other.capital))
            return false;
        if (cuotas == null) {
            if (other.cuotas != null)
                return false;
        } else if (!cuotas.equals(other.cuotas))
            return false;
        if (interes == null) {
            if (other.interes != null)
                return false;
        } else if (!interes.equals(other.interes))
            return false;
        if (saldo == null) {
            if (other.saldo != null)
                return false;
        } else if (!saldo.equals(other.saldo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cuota [cuotas=" + cuotas + ", capital=" + capital + ", interes=" + interes 
                + ", saldo=" + saldo + "]";
    }
    
    
    
    

}
