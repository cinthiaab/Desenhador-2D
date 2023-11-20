package mandala;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Contem metodos para desenhar Mandalas
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class FiguraMandalas
{
    public static MandalaGr mandala;
    
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
    public static void desenharMandala(Graphics g, int x1, int y1, int x2, int y2, String nome, int diametro, Color cor){
       mandala = new MandalaGr(x1, y1, x2, y2, cor, nome, diametro);
       mandala.desenharMandala(g);
    }
    
    public static void desenharMandala(Graphics g, MandalaGr mandalax){
        mandalax.desenharMandala(g);
    }
}
