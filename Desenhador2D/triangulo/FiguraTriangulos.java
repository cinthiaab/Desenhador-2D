package triangulo;
import java.awt.Color;
import java.awt.Graphics;
import triangulo.TrianguloGr;
import ponto.Ponto;

/**
 * triangulo matematico
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class FiguraTriangulos 
{
    
    public static TrianguloGr triangulo; 
    
    /**
     * Desenha uma reta de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param x3 coordenada x de p3
     * @param y3 coordenada y de p3
     * @param nome nome da reta
     * @param esp espessura da reta
     * @param cor cor da reta
     */
    public static void desenharTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, String nome, int diametro, Color cor){
       triangulo = new TrianguloGr(x1, y1, x2, y2, x3, y3, cor, nome, diametro);
       //arm.setArrayTriangulo(rg);
       triangulo.desenharTriangulo(g);
    }
    
    public static void desenharTriangulo(Graphics g, TrianguloGr triangulox){
        triangulox.desenharTriangulo(g);
    }
    
    //public static void zerar(){arm.setIndexTriangulo(0);}
}
