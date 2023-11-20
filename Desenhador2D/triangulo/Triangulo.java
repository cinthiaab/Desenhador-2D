package triangulo;
import ponto.Ponto;

/**
 * triangulo matematico
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class Triangulo
{
    // Atributos da reta
    private Ponto p1, p2, p3, p4;
    private double x1, x2, y1, y2, x3,y3;
    private int id;
    
    /**
     * Construtor dos objetos da classe Triangulo
     * @param x1 - coordenada x do primeiro ponto
     * @param y1 - coordenada y do primeiro ponto
     * @param x2 - coordenada x do segundo ponto
     * @param y2 - coordenada y do segundo ponto
     */
    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3) {
        setP1(new Ponto(x1, y1)); //primeiro ponto (vertice inferior esquerdo)
        setP2(new Ponto(x2, y2)); //segundo ponto (vertice superior direito)
        setP3(new Ponto(x3, y3)); //essa coordenada representa o vertice superior esquerdo
        setX1(x1);
        setX2(x2);
        setX3(x3);
        setY1(y1);
        setY2(y2);
        setY3(y3);
        setId(0);
        
    }
    
    public Triangulo(TrianguloGr p2d) {
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setX3(x3);
        setY3(y3);
        setId(0);
    }
    
    /**
     * 
     * @param p - ponto
     */
    public void setP1(Ponto p1){
        this.p1 = p1;
    }
    
    /**
     * 
     * @param p - ponto
     */
    public void setP2(Ponto p2){
        this.p2 = p2;
    }

    public void setP3(Ponto p3) {
        this.p3 = p3;
    }
    
    public Ponto getP1() {
        return this.p1;
    }

    public Ponto getP2() {
        return this.p2;
    }

    public Ponto getP3() {
        return this.p3;
    }

    public void setX1(double x1){
        this.x1 = x1;
    }

    public void setX2(double x2){
        this.x2 = x2;
    }
    
    public void setX3(double x3){
        this.x3 = x3;
    }

    public void setY1(double y1){
        this.y1 = y1;
    }

    public void setY2(double y2){
        this.y2 = y2;
    }
    
    public void setY3(double y3){
        this.y2 = y2;
    }
    
    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }
    
    public double getX3() {
        return this.x3;
    }

    public double getY1() {
        return this.y1;
    }

    public double getY2() {
        return this.y2;
    }
    
    public double getY3() {
        return this.y3;
    }
    
     public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public double calcularDistancia(Ponto p) {
        
        double d = 0.0;
        
        return(d);
    
    }
    
    /**
     * Calcula o coeficiente angular
     * @param Dy - delta y
     * @param Dx - delta x
     */
    public double calcularM(double Dy, double Dx){
        // m = (y2-y1)/(x2-x1)
        double m = (getP2().getY() - getP1().getY())/(getP2().getX() - getP1().getX());
        return m;
    }

    /**
     * Calcula a constante
     * @param m - coeficiente 
     */
     public double calcularB(double m){
        //b = y1 - mx1
        double b = getP1().getY() - m * getP1().getX();
        return b;
    }
}
