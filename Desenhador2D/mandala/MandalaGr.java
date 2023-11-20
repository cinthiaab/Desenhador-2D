package mandala;
import java.awt.Color;
import java.awt.Graphics;
import circulo.FiguraCirculos;
import retangulo.FiguraRetangulos;
import triangulo.FiguraTriangulos;
import reta.FiguraRetas;
import ponto.Ponto;

/**
 * implementacao da classe Mandala grafica
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class MandalaGr extends Mandala {

    Color corMandala = Color.BLACK; // cor do ponto
    Color corInicial = Color.BLACK;
    String Nome = ""; // nome do ponto
    Color corNome  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1
    private double x1, x2, y1, y2;

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public MandalaGr(int x1, int y1, int x2, int  y2){
        super((double)x1, (double)y1, (double)x2, (double)y2);    
        setCorNome(Color.black);     
        setNome(""); 
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
     * @param cor - cor do Mandala
     */
    public MandalaGr(int x1, int y1, int x2, int  y2, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorMandala(cor);
        corInicial = cor;
        setCorNome(cor);     
        setNome("");
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
     * @param corPonto - cor do Mandala
     * @param diametro - tamanho das bolinhas
     */
    public MandalaGr(int x1, int y1, int x2, int  y2, Color corPonto, int diametro) {
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
     * @param corPonto - cor do Mandala
     * @param nomePonto - nome do Mandala
     * @param diametro - tamanho dos desenhos
     */
    public MandalaGr(int x1, int y1, int x2, int  y2, Color corPonto, String nomePonto, int diametro){
        this(x1, y1, x2, y2, corPonto, diametro);
        setNome(nomePonto);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y1;

    }
    
    public MandalaGr(int x1, int y1, int x2, int  y2, Color cor1, Color cor2, String nomePonto, int diametro){
        this(x1, y1, x2, y2, cor1, diametro);
        setNome(nomePonto);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y1;

    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y- coordenada do y
     * @param cor - cor do Mandala
     * @param str - nome do Mandala
     */
    public MandalaGr(int x1, int y1, int x2, int  y2, Color cor, String str){
        super((double)x1, (double)y1, (double)x2, (double)y2);
        setCorMandala(cor);     
        setCorNome(cor);     
        setNome(str);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y1;

    }

    /**
     * Construtor
     * 
     * @param p2d
     * @param cor - cor do Mandala
     */
    public MandalaGr(MandalaGr p2d, Color cor){
        super(p2d);     
        setCorMandala(cor);     
        setCorNome(cor);     
        setNome(""); 
        this.y2 = y1;

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

    public Color getCor1(){
        return Color.RED;
    }

    public Color getCor2(){
        return Color.GREEN;
    }

    /**
     * @return the corMandala
     */
    public Color getCorMandala() {
        return corMandala;
    }

    /**
     * @param corMandala the corMandala to set
     */
    public void setCorMandala(Color corMandala) {
        this.corMandala = corMandala;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the corNome
     */
    public Color getCorNome() {
        return corNome;
    }

    /**
     * @param corNome the corNome to set
     */
    public void setCorNome(Color corNome) {
        this.corNome = corNome;
    }

    /**
     * @return the diametro
     */
    public int getDiametro() {
        return diametro;
    }

    public void resetCor(){
        corMandala = corInicial;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public void desenharMandala(Graphics g){
        g.setColor(getCorMandala());

        desenharMandala(g, (int)getX1(), (int)getY1(), (int)getX2(), (int)getY2());
    }   

    public double calcularDistancia(Ponto p) {

        double d = 0.0;

        return(d);

    }

    /**
     * 
     * Desenha as retas do Mandala
     *
     * @param g - conteudo grafico
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     */
    public void desenharMandala(Graphics g, int _x1, int _y1, int _x2, int _y2){
        int x_circulo_principal, y_circulo_principal, h1, h2, metade_raio, raio;
        int x1, x2, x3, x4, x5, x6, y1, y2, y3, y4;
        raio = (int) calcularRaio();
        metade_raio = raio/2;
        x_circulo_principal=_x1; y_circulo_principal = _y1;

        h1 = (int) ((raio * Math.sqrt(3))/2);
        h2 = (int) ((raio * Math.sqrt(3)));

        x1= (int) (x_circulo_principal-metade_raio);
        y1 = (int) (y_circulo_principal-h1);
        x2= (int) (x_circulo_principal+metade_raio);
        y2 = (int) (y_circulo_principal+h1);
        x3 = (x_circulo_principal+3*metade_raio); 
        x4 = (x_circulo_principal-3*metade_raio);
        x5= x_circulo_principal-raio;
        x6 = x_circulo_principal+raio;

        FiguraCirculos circulo_principal = new FiguraCirculos();
        FiguraCirculos circulo_aux1 = new FiguraCirculos();
        FiguraRetangulos retangulo = new FiguraRetangulos();
        FiguraTriangulos triangulo = new FiguraTriangulos();
        FiguraRetas reta = new FiguraRetas();

        retangulo.desenharRetangulo(g, x3, y1, x4, y2, getNome(), getDiametro(), Color.RED);

        reta.desenharReta(g, x5, y_circulo_principal, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x6, y_circulo_principal, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        
        //as 2 linhas a seguir tamb?m foram alteradas, antigamente a reta tra?ada apenas alcan?ava metade do mandala
        reta.desenharReta(g, x_circulo_principal, y1, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x_circulo_principal, y2, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        
        
        reta.desenharReta(g, x1, y1, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x2, y2, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x1, y2, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x2, y1, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);

        
        // altera??es (PS: Alguns c?lculos poderiam ser feitos simplesmente com triangulos mas foi preferivel manter a l?gica com retas)
        
        reta.desenharReta(g, x4, y2, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y1, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y2, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y1, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y2, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y1, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);                     
        reta.desenharReta(g, x3, y1, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x3, y2, x_circulo_principal, y_circulo_principal+2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x3, y1, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x3, y2, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x3, y1, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x3, y2, x_circulo_principal, y_circulo_principal-2*h1, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y2, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x4, y1, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);                        
        reta.desenharReta(g, x3, y1, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);
        reta.desenharReta(g, x3, y2, x_circulo_principal, y_circulo_principal, getNome(), getDiametro(), Color.RED);

        
        
        circulo_principal.desenharCirculo(g,x_circulo_principal, y_circulo_principal, x2,  y2,  getNome(), getDiametro(), Color.GREEN);
        circulo_aux1.desenharCirculo(g,x5, y_circulo_principal, x_circulo_principal,  y_circulo_principal,  getNome(), getDiametro(), Color.GREEN);
        circulo_aux1.desenharCirculo(g,x6, y_circulo_principal, x_circulo_principal,  y_circulo_principal,  getNome(), getDiametro(), Color.GREEN);
        circulo_aux1.desenharCirculo(g,x1, y1, x_circulo_principal,  y_circulo_principal,  getNome(), getDiametro(), Color.GREEN);
        circulo_aux1.desenharCirculo(g,x2, y1, x_circulo_principal,  y_circulo_principal,  getNome(), getDiametro(), Color.GREEN);
        circulo_aux1.desenharCirculo(g,x1, y2, x_circulo_principal,  y_circulo_principal,  getNome(), getDiametro(), Color.GREEN);
        circulo_aux1.desenharCirculo(g,x2, y2, x_circulo_principal,  y_circulo_principal,  getNome(), getDiametro(), Color.GREEN);

        //desenharTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, String nome, int diametro, Color cor)
    }  
}
