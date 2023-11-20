package circulo;
import ponto.Ponto;

/**
 * Circulo matematico
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class Circulo
{
    // Atributos da reta
    private Ponto p1, p2;
    private double x1, x2, y1, y2;
    private int id;
    protected double raio;
    
    /**
     * Construtor dos objetos da classe Circulo
     * @param x1 - coordenada x do primeiro ponto
     * @param y1 - coordenada y do primeiro ponto
     * @param x2 - coordenada x do segundo ponto
     * @param y2 - coordenada y do segundo ponto
     */
    public Circulo(double x1, double y1, double x2, double y2) {
        setP1(new Ponto(x1, y1)); //primeiro ponto (vertice inferior esquerdo)
        setP2(new Ponto(x2, y2)); //segundo ponto (vertice superior direito)
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setId(0);
        this.raio = calcularRaio();
    }
    
    public Circulo(double x1, double y1, double raio) {
        setP1(new Ponto(x1, y1)); //primeiro ponto (vertice inferior esquerdo)
        double x2 = x1, y2=y1+raio;
        setP2(new Ponto(x2, y2)); //segundo ponto (vertice superior direito)
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
        setId(0);
        this.raio = raio;
    }
    
    public Circulo(CirculoGr p2d) {
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
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
    
    public Ponto getP1() {
        return this.p1;
    }

    public Ponto getP2() {
        return this.p2;
    }

    public void setX1(double x1){
        this.x1 = x1;
    }

    public void setX2(double x2){
        this.x2 = x2;
    }

    public void setY1(double y1){
        this.y1 = y1;
    }

    public void setY2(double y2){
        this.y2 = y2;
    }
    
    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public double getY1() {
        return this.y1;
    }

    public double getY2() {
        return this.y2;
    }
    
     public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    /**
     * Calcula a constante
     * @param m - coeficiente 
     */
     public double calcularRaio(){
        double raio = Math.sqrt(Math.pow(getX1()-getX2(), 2) + Math.pow(getY1()-getY2(), 2));
        return raio;
    }
}
