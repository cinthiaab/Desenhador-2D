package reta;
import java.awt.Color;
import java.awt.Graphics;
import ponto.Ponto;
import ponto.PontoGr;

/**
 * Implementacao da classe reta grafica.
 *
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class RetaGr extends Reta{
    // Atributos da reta grafica
    Color corReta = Color.BLACK;   // cor da reta
    String nomeReta = ""; // nome da reta
    Color corNomeReta  = Color.BLACK;
    int espReta = 1; // espessura da reta

    // Construtores
    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     * @param nome String. Nome da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor, String nome, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta(nome);
        setEspReta(esp);
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta("");
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     * @param cor Color. Cor da reta
     * @param esp int. Espessura da reta
     */
    public RetaGr(int x1, int y1, int x2, int y2, Color cor, int esp){
        super (x1, y1, x2, y2);
        setCorReta(cor);
        setNomeReta("");
        setEspReta(esp);
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param x1 int. Coordenada x1
     * @param y1 int. Coordenada y1
     * @param x2 int. Coordenada x2
     * @param y2 int. Coordenada y2
     */
    public RetaGr(int x1, int y1, int x2, int y2){
        super (x1, y1, x2, y2);
        setCorReta(Color.black);
        setNomeReta("");
    }   

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     */
    public RetaGr(PontoGr p1, PontoGr p2){
        super(p1, p2);
        setCorReta(Color.black);
        setNomeReta("");
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor da reta
     */
    public RetaGr(PontoGr p1, PontoGr p2, Color cor){
        super(p1, p2);
        setCorReta(cor);
        setNomeReta("");
    }    

    /**
     * RetaGr - Constroi uma reta grafica
     *
     * @param p1 PontoGr. Ponto grafico p1 (x1, y1)
     * @param p2 PontoGr. Ponto grafico p2 (x2, y2)
     * @param cor Color. Cor da reta
     * @param nome String. Nome da reta
     */
    public RetaGr(PontoGr p1, PontoGr p2, Color cor, String str){
        super(p1, p2);
        setCorReta(cor);
        setNomeReta(str);
    }    

    /**
     * Altera a cor da reta.
     *
     * @param cor Color. Cor da reta.
     */
    public void setCorReta(Color cor) {
        this.corReta = cor;
    }

    /**
     * Altera o nome da reta.
     *
     * @param str String. Nome da reta.
     */
    public void setNomeReta(String str) {
        this.nomeReta = str;
    }

    /**
     * Altera a espessura da reta.
     *
     * @param esp int. Espessura da reta.
     */
    public void setEspReta(int esp) {
        this.espReta = esp;
    }

    /**
     * Retorna a espessura da reta.
     *
     * @return int. Espessura da reta.
     */
    public int getEspReta() {
        return(this.espReta);
    }

    /**
     * Retorna a cor da reta.
     *
     * @return Color. Cor da reta.
     */
    public Color getCorReta() {
        return corReta;
    }

    /**
     * Retorna o nome da reta.
     *
     * @return String. Nome da reta.
     */
    public String getNomeReta() {
        return nomeReta;
    }

    /**
     * @return the corNomeReta
     */
    public Color getCorNomeReta() {
        return corNomeReta;
    }

    /**
     * @param corNomeReta the corNomeReta to set
     */
    public void setCorNomeReta(Color corNomeReta) {
        this.corNomeReta = corNomeReta;
    }
    
    
    
    public double calcularDistancia(Ponto p) {
        
        double d = 0.0;
        
        return(d);
    
    }
    public double distanciaEntrePontoEReta(double pontoX, double pontoY) {
        // Calcula os coeficientes da equação da reta (Ax + By + C = 0) com base em dois pontos
        double A = this.getP2().getY() - this.getP1().getY();
        double B = this.getP1().getX()  - this.getP2().getX() ;
        double C = (this.getP2().getX() * this.getP1().getY()) - (this.getP1().getX() * this.getP2().getY());

        // Calcula o numerador (Ax + By + C)
        double numerador = Math.abs(A * pontoX + B * pontoY + C);

        // Calcula o denominador (sqrt(A^2 + B^2))
        double denominador = Math.sqrt(A * A + B * B);

        // Calcula a distância
        double distancia = numerador / denominador;

        return distancia;
    }
    
    public String toString(){
        String txt = "{\n\t\t";
        txt += getP1().toString();
        txt += getP2().toString();    
        return txt;
    }
    /**
     * desenha um Reta utilizando o oval 
     * 
     * @param g contexto grafico
     * @param cor
     * @param y2
     * @param x2
     * @param y1
     * @param x1
     */
    public void desenharReta(Graphics g){
        g.setColor(getCorReta());

        double Dx=0, Dy=0;// Delta x; Delta y
        double m=0, b=0;// Coeficinete angular; b
        double c1, c2; //Variaveis utilizadas para identificar e armazenar qual delta é maior para realizar o loop de criacao de uma reta mais precisa
        double xMaior=0, xMenor=0, yMaior=0,yMenor=0;
        double x1 = getP1().getX(), x2 = getP2().getX(), y1 = getP1().getY(), y2 = getP2().getY();
        double x, y;

        //Identifica qual ponto tem o eixo x com maior valor e realiza a conta do delta x
        if(x2 > x1){
            Dx = x2 - x1;
            xMaior = x2;
            xMenor = x1;
        }else if(x2 < x1){
            Dx = x1 - x2;
            xMaior = x1;
            xMenor = x2;
        }

        //Identifica qual ponto tem o eixo y com maior valor e realiza a conta do delta y
        if(y2 >= y1){
            Dy = y2 - y1;
            yMaior = y2;
            yMenor = y1;
        }else if(y2 < y1){
            Dy = y1 - y2;
            yMaior = y1;
            yMenor = y2;
        }
        
        //Identifica qual delta é maior, com intuito de definir qual dos eixos possui maior variação 
        if(Dx > Dy) {
            c1 = xMenor;
            c2 = xMaior;
        }else{
            c1 = yMenor;
            c2 = yMaior;
        } 

        //delta x for igual a 0
        if(Dx == 0){
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)x1 -(getEspReta()/2), (int)i - (getEspReta()/2), getEspReta(), getEspReta());
            }
        //delta y for igual a 0
        }else if(Dy == 0){ //Neste caso, a reta será horizontal
            for(double i = c1; i <= c2; i++){

                g.fillOval((int)i -(getEspReta()/2), (int)y1 - (getEspReta()/2), getEspReta(), getEspReta());
            }
        }else{
            m = calcularM(Dy, Dx);
            b = calcularB(m);

            for(double i = c1; i <= c2; i++){
                if(Dx > Dy){
                    y = i*m + b; //equacao reduzida da reta
                    g.fillOval((int)i -(getEspReta()/2), (int)y - (getEspReta()/2), getEspReta(), getEspReta());
                }else{
                    x = (i - b)/m;// equacao reduzida da reta com o x isolado
                    g.fillOval((int)x -(getEspReta()/2), (int)i - (getEspReta()/2), getEspReta(), getEspReta());
                }
            }         
        }
        
    } 
    
    
    

    /**
     * Desenha reta grafica utilizando a equacao da reta: y = mx + b
     *
     * @param g Graphics. Classe com os metodos graficos do Java
     */
    /*public void desenharReta(Graphics g){

        // calcula m e b da equacao da reta y = mx + b
        double m = calcularM();
        double b = calcularB();

        // Variaveis auxiliares
        PontoGr ponto; 
        double x, y;

        double pIni;
        double pFim;

        // desenha nome do ponto
        g.setColor(getCorNomeReta());
        g.drawString(getNomeReta(), (int)getP1().getX() + getEspReta(), (int)getP1().getY());

        // percorre de x1 ate x2. 
        // y e´ calculado pela equacao: y = mx + b
        pIni = p1.getX();
        pFim = p2.getX();
        for(x = pIni; x <= pFim; x++){ 
            // Calculo de y pela equacao da reta
            y = (m*x + b);

            // Define ponto grafico
            ponto = new PontoGr((int)x, (int)y, getCorReta(), getEspReta());

            // Desenha ponto grafico
            ponto.desenharPonto(g);
        }
    }*/
}