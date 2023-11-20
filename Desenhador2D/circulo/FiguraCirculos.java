package circulo;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Contem metodos para desenhar Circulos
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class FiguraCirculos
{
    public static CirculoGr circulo;   
    /**
     * Desenha uma reta de acordo com os pontos p1 e p2
     *
     * @param g biblioteca para desenhar o primitivo grafico
     * @param x1 coordenada x de p1
     * @param y1 coordenada y de p1
     * @param x2 coordenada x de p2
     * @param y2 coordenada y de p2
     * @param nome nome da reta
     * @param esp espessura da reta
     * @param cor cor da reta
     */
    public static void desenharCirculo(Graphics g, int x1, int y1, int x2, int y2, String nome, int diametro, Color cor){
       circulo = new CirculoGr(x1, y1, x2, y2, cor, nome, diametro);
       circulo.desenharCirculo(g);
    }
    
    public static void desenharCirculo(Graphics g, CirculoGr circulox){
        circulox.desenharCirculo(g);
    }
    
    public static void desenharCirculo(Graphics g, int x1, int y1, int raio, String nome, int diametro, Color cor){
       circulo = new CirculoGr(x1, y1, raio, cor, nome, diametro);
       circulo.desenharCirculo(g);
    }
    
}
