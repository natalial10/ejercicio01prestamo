package com.eiv.prueba;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class App {
    
    public static final BigDecimal DIAS = BigDecimal.valueOf(30);
    public static final BigDecimal CIEN = BigDecimal.valueOf(100);
    public static final BigDecimal DIAS_ANIO = BigDecimal.valueOf(365);
    
    private static final Logger LOG = LogManager.getLogger(App.class);
    
    public static void main(String[] args){
        
        LOG.info("Iniciando aplicación ...");
        App app = new App();
        app.run();
        
    }
    
    public void run() {
        
        LOG.debug("Pido al usuario los datos del prestamo a calcular ...");
        //carga inicial de los datos
        PrestamoDatos prestamoDatos = cargarDatos();
        
        LOG.debug("Calculo el valor de las cuotas ...");
        //calculo las cuotas de prestamo
        List<Cuota> cuotas = calcularCuotas(prestamoDatos);
        
        //muestro en pantalla las cuotas
        
        LOG.debug("Muestro tabla de resultados ...");
        cuotas.forEach(cuota -> {
            System.out.println(cuota);
        });
    }


    public PrestamoDatos cargarDatos() {
                 
            
            Scanner sc = new Scanner(System.in);
            
            BigDecimal capital =null;
            Integer cuotas = null;
            BigDecimal tna = null;
            
            try {
                
                System.out.println("Ingrese el Capital del prestamo:");
                capital = sc.nextBigDecimal();

                System.out.println("Ingrese Cantidad de Cuotas:");
                cuotas = sc.nextInt();
            
                System.out.println("Ingrese TNA:");
                tna= sc.nextBigDecimal();
            
            } catch (InputMismatchException e) {
                System.out.println("Error, ingreso un valor incorrecto");
                            
            } finally {  
                       
                sc.close();
            }
            PrestamoDatos  prestamoDatos =  new PrestamoDatos(capital, cuotas ,tna);
  
            return prestamoDatos;
        
    
        }
    
    
  public List<Cuota> calcularCuotas(PrestamoDatos prestamoDatos){
        
      
        int nroCuotas = prestamoDatos.getCuotas().intValue();
        
        BigDecimal razon = prestamoDatos.getTna()
                .multiply(DIAS)
                .divide(CIEN.multiply(DIAS_ANIO), 6, RoundingMode.HALF_UP);
        
        BigDecimal valorCuota = calculoValorCuota(prestamoDatos);
        BigDecimal saldoCapital =prestamoDatos.getCapital();
        
        LOG.debug("Valor de la cuota calculada..."+valorCuota);
        
        List<Cuota> cuotas = new ArrayList<>();
 
        
        for (int i=1; i <= nroCuotas; i++) {
            
            BigDecimal interes = saldoCapital.multiply(razon)
                    .setScale(2, RoundingMode.HALF_UP);
            
            BigDecimal capitalCuota = valorCuota.subtract(interes);
            
            saldoCapital =saldoCapital.subtract(capitalCuota);
            
            Cuota cuota = new Cuota(
                    i,capitalCuota,interes,saldoCapital);
            
            cuotas.add(cuota);
                       
        }
        return cuotas;
            
        
        
        
    }
    
    
    public BigDecimal calculoValorCuota(PrestamoDatos prestamoDatos) {
        
        LOG.debug("Calculo el valor de la cuota ...");
        BigDecimal razon = prestamoDatos.getTna()
                .multiply(DIAS)
                .divide(CIEN.multiply(DIAS_ANIO),6,RoundingMode.HALF_UP);
        
        BigDecimal factor= razon.add(BigDecimal.ONE).pow(prestamoDatos.getCuotas());
        
        BigDecimal valorCuota= prestamoDatos.getCapital()
                .multiply(razon)
                .multiply(factor)
                .divide(factor.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
        
        return valorCuota;
        
              
            
            
    }
    
       
    
}
