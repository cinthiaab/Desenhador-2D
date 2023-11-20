package circulo;
import java.awt.Color;
import java.awt.Graphics;
import ponto.Ponto;
import ponto.PontoGr;

/**
 * implementacao da classe Circulo grafica
 * 
* @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class CirculoGr extends Circulo {

    Color corCirculo = Color.BLACK; // cor do ponto
    Color corInicial = Color.BLACK;
    String nomeCirculo = ""; // nome do ponto
    Color corNomeCirculo  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1
    private double x1, x2, y1, y2;
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public CirculoGr(int x1, int y1, int x2, int  y2){
        super((double)x1, (double)y1, (double)x2, (double)y2);    
        setCorNomeCirculo(Color.black);     
        setNomeCirculo(""); 
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y1;
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param cor - cor do Circulo
     */
    public CirculoGr(int x1, int y1, int x2, int  y2, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorCirculo(cor);
        corInicial = cor;
        setCorNomeCirculo(cor);     
        setNomeCirculo("");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y1;
    }

    public CirculoGr(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorCirculo(cor);
        corInicial = cor;
        setCorNomeCirculo(cor);     
        setNomeCirculo("");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do Circulo
     * @param diametro - tamanho das bolinhas
     */
    public CirculoGr(int x1, int y1, int x2, int  y2, Color corPonto, int diametro) {
        this(x1, y1, x2, y2, corPonto);
        setDiametro(diametro);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y1;
        
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do Circulo
     * @param nomePonto - nome do Circulo
     * @param diametro - tamanho dos desenhos
     */
    public CirculoGr(int x1, int y1, int x2, int  y2, Color corPonto, String nomePonto, int diametro){
        this(x1, y1, x2, y2, corPonto, diametro);
        setNomeCirculo(nomePonto);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
    }
    public CirculoGr(int x1, int y1, double raio, Color corPonto, String nomePonto, int diametro){
        super((double) x1, (double) y1, raio);
        setNomeCirculo(nomePonto);
        this.x1 = x1;
        this.y1 = y1;
        
    }
    
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y- coordenada do y
     * @param cor - cor do Circulo
     * @param str - nome do Circulo
     */
    public CirculoGr(int x1, int y1, int x2, int  y2, Color cor, String str){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorCirculo(cor);     
        setCorNomeCirculo(cor);     
        setNomeCirculo(str);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        }
    public CirculoGr(int x1, int y1, double raio, Color cor, String str){
        super((double)x1, (double)y1, (raio));
        setCorCirculo(cor);     
        setCorNomeCirculo(cor);     
        setNomeCirculo(str);
        this.x1 = x1;
        this.y1 = y1;
        
        
         
    }
    
    public double getRaio(){
        return this.raio;
    }

    /**
     * Construtor
     * 
     * @param p2d
     * @param cor - cor do Circulo
     */
    public CirculoGr(CirculoGr p2d, Color cor){
        super(p2d);     
        setCorCirculo(cor);     
        setCorNomeCirculo(cor);     
        setNomeCirculo(""); 
         
    }
    
    public double calcularRaio() {
        double x1 = getP1().getX();
        double y1 = getP1().getY();
        double x2 = getP2().getX();
        double y2 = getP2().getY();

        // Usamos a fórmula da distância entre dois pontos para calcular o raio.
        double raio = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        return raio;
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

    

    /**
     * @return the corCirculo
     */
    public Color getCorCirculo() {
        return corCirculo;
    }

    /**
     * @param corCirculo the corCirculo to set
     */
    public void setCorCirculo(Color corCirculo) {
        this.corCirculo = corCirculo;
    }

    /**
     * @return the nomeCirculo
     */
    public String getNomeCirculo() {
        return nomeCirculo;
    }

    /**
     * @param nomeCirculo the nomeCirculo to set
     */
    public void setNomeCirculo(String nomeCirculo) {
        this.nomeCirculo = nomeCirculo;
    }

    /**
     * @return the corNomeCirculo
     */
    public Color setCorNomeCirculo() {
        return corNomeCirculo;
    }

    /**
     * @param corNomeCirculo the corNomeCirculo to set
     */
    public void setCorNomeCirculo(Color corNomeCirculo) {
        this.corNomeCirculo = corNomeCirculo;
    }

    /**
     * @return the diametro
     */
    public int getDiametro() {
        return diametro;
    }

    public void resetCor(){
        corCirculo = corInicial;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    
    public double calcularDistancia(Ponto p) {
        
        double d = 0.0;
        
        return(d);
    
    }
    
    /**
     * Desenha o Circulo
     * 
     * @param g - conteudo gráfico
     * 
     */
    public void desenharCirculo(Graphics g){
        g.setColor(getCorCirculo());
        
        desenharCirculo(g, (int)getX1(), (int)getY1());
    }   
    
    public void desenharPontosSimetricos(Graphics g, int x, int y){
        PontoGr ponto1 = new PontoGr((int) x, (int) y, getCorCirculo(), "", getDiametro());
        ponto1.desenharPonto(g);
        PontoGr ponto2 = new PontoGr((int) -x, (int) y, getCorCirculo(), "", getDiametro());
        ponto2.desenharPonto(g);
        PontoGr ponto3 = new PontoGr((int) x, (int) -y, getCorCirculo(), "", getDiametro());
        ponto3.desenharPonto(g);
        PontoGr ponto4 = new PontoGr((int) -x, (int) -y, getCorCirculo(), "", getDiametro());
        ponto4.desenharPonto(g);
        PontoGr ponto5 = new PontoGr((int) y, (int) x, getCorCirculo(), "", getDiametro());
        ponto5.desenharPonto(g);
        PontoGr ponto6 = new PontoGr((int) -y, (int) -x, getCorCirculo(), "", getDiametro());
        ponto6.desenharPonto(g);
        PontoGr ponto7 = new PontoGr((int) -y, (int) x, getCorCirculo(), "", getDiametro());
        ponto7.desenharPonto(g);
        PontoGr ponto8 = new PontoGr((int) y, (int) -x, getCorCirculo(), "", getDiametro());
        ponto8.desenharPonto(g);
    }
    /**
     * 
     * Desenha as retas do Circulo
     *
     * @param g - conteudo grafico
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     */
    public void desenharCirculo(Graphics g, int xc, int yc){
        int x, y;
        double raio = this.calcularRaio();
        
        for (int i = 0; i <= 360; i++)
        {
            x = (int) (xc + raio * Math.cos(Math.toRadians(i)));
            y = (int) (yc + raio * Math.sin(Math.toRadians(i)));
            g.setColor(Color.black);
            PontoGr ponto1 = new PontoGr((int) x, (int) y, getCorCirculo(), "", getDiametro());
            ponto1.desenharPonto(g);
            //desenharPontosSimetricos(g, x, y);
        }
    }  
}
