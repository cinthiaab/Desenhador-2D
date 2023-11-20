package reta;
import ponto.Ponto;
import ponto.PontoGr;
/**
 * Reta matematica.
 *
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class Reta {
 
    // Atributos da reta
    public PontoGr p1, p2;
    private int id;

    /**
     * Constroi uma reta com valores (int) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Reta(int x1, int y1, int x2, int y2) {
        setP1(new PontoGr((int)x1, (int)y1));
        setP2(new PontoGr((int)x2, (int)y2));
        setId(0);
    }
    
    /**
     * Constroi uma reta com valores (double) de x1, y1 e x2, y2
     *
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     */
    public Reta(double x1, double y1, double x2, double y2) {
        setP1(new PontoGr((int)x1, (int)y1));
        setP2(new PontoGr((int)x2, (int)y2));
        setId(0);
    }
    
    /**
     * Controi uma reta com valores de p1 e p2 (externos)
     *
     * @param p1 Um parâmetro
     * @param p2 Um parâmetro
     */
    public Reta(PontoGr p1, PontoGr p2) {
        setP1(p1);
        setP2(p2);
        setId(0);
    }
    
    /**
     * Constroi uma reta com dados de outra (externa)
     *
     * @param r reta externa
     */
    public Reta (RetaGr r){
        setP1(r.getP1());
        setP2(r.getP2());
        setId(0);
    }
    
    /**
     * Altera valor de p1 de acordo com o parametro
     *
     * @param p valor de p1 (externo)
     */
    public void setP1(PontoGr p){
        this.p1 = p;
    }
    
    /**
     * Altera valor de p2 de acordo com o parametro
     *
     * @param p valor de p2 (externo)
     */
    public void setP2(PontoGr p){
        this.p2 = p;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    /**
     * Retorna valor de p1
     *
     * @return valor de p1
     */
    public PontoGr getP1(){
        return this.p1;
    }
    
    /**
     * Retorna p2
     *
     * @return valor de p2
     */
    public PontoGr getP2(){
        return this.p2;
    }
    
    public double calcularDistancia(PontoGr p) {
        double A = getP2().getY() - getP1().getY();
        double B = getP1().getX() - getP2().getX();
        double C = (getP2().getX() * getP1().getY()) - (getP1().getX() * getP2().getY());
        
        double d = Math.abs((A * p.getX() + B * p.getY() + C)) / Math.sqrt(A * A + B * B);
        
        return(d);
    
    }
    
     /**
     * 
     * @param Dy - delta y
     * @param Dx - delta x
     */
    public double calcularM(double Dy, double Dx){
        // m = (y2-y1)/(x2-x1)
        double m = (getP2().getY() - getP1().getY())/(getP2().getX() - getP1().getX());
        return m;
    }

    /**
     * 
     * @param m - coeficiente 
     */
     public double calcularB(double m){
        //b = y1 - mx1
        double b = getP1().getY() - m * getP1().getX();
        return b;
    }
    
    
    /**
     * Method toString
     *
     * @return s - String
     */
    public String toString(){
        String s = "P1: " + getP1().toString() + " P2: " + getP2().toString();
        //s = s + "\nEq. da reta: y = " + calcularM() + "*x + " + calcularB();
        return s;
    }
}
