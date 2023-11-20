package triangulo;
import java.awt.Color;
import java.awt.Graphics;
import ponto.Ponto;
import ponto.PontoGr;
import reta.RetaGr;
import reta.Reta;

/**
 * implementacao da classe Triangulo grafica
 * 
* @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class TrianguloGr extends Triangulo
{
    
    Color corTriangulo = Color.BLACK; // cor do ponto
    Color corInicial = Color.BLACK;
    String nomeTriangulo = ""; // nome do ponto
    Color corNomeTriangulo  = Color.BLACK; // cor do nome (string) do ponto  
    int diametro = 1; // diametro do ponto, default = 1
    private double x1, x2, x3, y1, y2, y3;
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     */
    public TrianguloGr(int x1, int y1, int x2, int  y2, int x3, int  y3){
        super((double)x1, (double)y1, (double)x2, (double)y2, (double)x3, (double)y3);    
        setCorNomeTriangulo(Color.black);     
        setNomeTriangulo(""); 
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;   
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param cor - cor do Triangulo
     */
    public TrianguloGr(int x1, int y1, int x2, int  y2, int x3, int y3, Color cor){
        super((double)x1, (double)y1, (double)x2, (double)y2, (double)x3, (double)y3);    
        setCorTriangulo(cor);
        corInicial = cor;
        setCorNomeTriangulo(cor);     
        setNomeTriangulo("");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;     
    }

    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do Triangulo
     * @param diametro - tamanho das bolinhas
     */
    public TrianguloGr(int x1, int y1, int x2, int  y2, int x3, int y3, Color corPonto, int diametro) {
        this(x1, y1, x2, y2, x3, y3, corPonto);
        setDiametro(diametro);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3; 
    }
    
    /**
     * Construtor
     * 
     * @param x - coordenada do x
     * @param y - coordenada do y
     * @param corPonto - cor do Triangulo
     * @param nomePonto - nome do Triangulo
     * @param diametro - tamanho dos desenhos
     */
    public TrianguloGr(int x1, int y1, int x2, int  y2, int x3, int  y3, Color corPonto, String nomePonto, int diametro){
        this(x1, y1, x2, y2, x3, y3, corPonto, diametro);
        setNomeTriangulo(nomePonto);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3; 
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
        this.y3 = y3;
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
    
    public double getX3() {
        return this.x3;
    }

    public double getY3() {
        return this.y3;
    }
    
    public Ponto getP1() {
        return new Ponto(x1, y1);
    }

    public Ponto getP2() {
        return new Ponto(x2, y2);
    }

    public Ponto getP3() {
        return new Ponto(x3, y3);
    }

    public void setP1(Ponto p) {
        x1 = p.x;
        y1 = p.y;
    }

    public void setP2(Ponto p) {
        x2 = p.x;
        y2 = p.y;
    }

    public void setP3(Ponto p) {
        x3 = p.x;
        y3 = p.y;
    }

    /**
     * @return the corTriangulo
     */
    public Color getCorTriangulo() {
        return corTriangulo;
    }

    /**
     * @param corTriangulo the corTriangulo to set
     */
    public void setCorTriangulo(Color corTriangulo) {
        this.corTriangulo = corTriangulo;
    }

    /**
     * @return the nomeTriangulo
     */
    public String getNomeTriangulo() {
        return nomeTriangulo;
    }

    /**
     * @param nomeTriangulo the nomeTriangulo to set
     */
    public void setNomeTriangulo(String nomeTriangulo) {
        this.nomeTriangulo = nomeTriangulo;
    }

    /**
     * @return the corNomeTriangulo
     */
    public Color setCorNomeTriangulo() {
        return corNomeTriangulo;
    }

    /**
     * @param corNomeTriangulo the corNomeTriangulo to set
     */
    public void setCorNomeTriangulo(Color corNomeTriangulo) {
        this.corNomeTriangulo = corNomeTriangulo;
    }

    /**
     * @return the diametro
     */
    public int getDiametro() {
        return diametro;
    }

    public void resetCor(){
        corTriangulo = corInicial;
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
     * Desenha o Triangulo
     * 
     * @param g - conteudo gráfico
     * 
     */
    public void desenharTriangulo(Graphics g){
        g.setColor(getCorTriangulo());
        //double x1 = getP1().getX(), x2 = getP2().getX(), y1 = getP1().getY(), y2 = getP2().getY();

        //Construindo as 4 retas do Triangulo. 
        //primeira reta -> (x1,y1), (x2,y1) 

        desenharReta(g, (int) x1, (int) y1, (int) x2, (int) y2);

        //segunda reta -> (x2,y1), (x2,y2)
        desenharReta(g, (int) x2, (int) y2, (int) x3, (int) y3);

        //terceira reta -> (x2,y2), (x1,y2)
        desenharReta(g, (int) x3, (int) y3, (int) x1, (int) y1);

        

    }   
    
   
    /**
     * 
     * Desenha as retas do Triangulo
     *
     * @param g - conteudo grafico
     * @param x1 - coordenada do x1
     * @param y1 - coordenada do y1
     * @param x2 - coordenada do x2
     * @param y2 - coordenada do y2
     */
    public void desenharReta(Graphics g, int _x1, int _y1, int _x2, int _y2){
        int dx = _x2 - _x1; //Delta X
        int dy = _y2 - _y1; //Delta Y
        
        int m = (Math.abs(dx) > Math.abs(dy)) ? Math.abs(dx) : Math.abs(dy); //Pega o maior delta absoluto (Quantidade de pontos para desenhar a reta)
        
        float _x = dx / (float) m; //Calcula o quanto precisa aumentar de x para seguir na direcao da reta
        float _y = dy / (float) m; //Calcula o quanto precisa aumentar de y para seguir na direcao da reta
        
        float x = _x1; //Ponto inicial X
        float y = _y1; //Ponto incial Y
    
        for (int i = 0; i <= m; i++)
        {
            g.setColor(Color.black);
            PontoGr ponto = new PontoGr((int) x, (int) y, getCorTriangulo(), "", getDiametro());
            ponto.desenharPonto(g);
            x += _x; //Incrementa X
            y += _y; //Incrementa Y
        }
    }  
}
