import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ponto.FiguraPontos;
import reta.FiguraRetas;
import retangulo.FiguraRetangulos;

import triangulo.FiguraTriangulos;
import circulo.FiguraCirculos;
import mandala.FiguraMandalas;
import ed.ArmazenadorPrincipal;
import ed.ArmazenadorPontos;

import javax.swing.*;

import ponto.PontoGr;
import ponto.Ponto;
// import reta.RetaGr;
// import retangulo.RetanguloGr;

// import triangulo.TrianguloGr;
// import circulo.CirculoGr;
// import mandala.MandalaGr;

/**
 * Cria desenhos de acordo com o tipo e eventos do mouse
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {

    JLabel msg;           // Label para mensagens
    TipoPrimitivo tipo; // Tipo do primitivo
    Color corAtual;       // Cor atual do primitivo
    int esp;              // Diametro do ponto

    int a=0;
    // Para ponto
    int x, y;
    public ArmazenadorPrincipal estrutura_de_dados = new ArmazenadorPrincipal();
    ArmazenadorPontos edp = new ArmazenadorPontos();

    // Para reta e retangulo
    int x1, y1, x2, y2, x3, y3;
    
    String tipoSelecionado = ""; // tipo da seleção
    int indiceSelecionado = -1;

    // selecionar primeiro click do mouse
    boolean primeiraVez = true;
    boolean segundaVez = false;
    boolean limpa_tela= false;
    

    /**
     * Constroi o painel de desenho
     *
     * @param msg mensagem a ser escrita no rodape do painel
     * @param tipo tipo atual do primitivo
     * @param corAtual cor atual do primitivo
     * @param esp espessura atual do primitivo
     */
    public PainelDesenho(JLabel msg, TipoPrimitivo tipo, Color corAtual, int esp){
        setTipo(tipo);
        setMsg(msg);
        setCorAtual(corAtual);
        setEsp(esp);

        // Adiciona "ouvidor" de eventos de mouse
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);

    }

    /**
     * Altera o tipo atual do primitivo
     *
     * @param tipo tipo do primitivo
     */
    public void setTipo(TipoPrimitivo tipo){
        this.tipo = tipo;
    }

    /**
     * Retorna o tipo do primitivo
     *
     * @return tipo do primitivo
     */
    public TipoPrimitivo getTipo(){
        return this.tipo;
    }

    /**
     * Altera a espessura do primitivo
     *
     * @param esp espessura do primitivo
     */
    public void setEsp(int esp){
        this.esp = esp;
    }

    /**
     * Retorna a espessura do primitivo
     *
     * @return espessura do primitivo
     */
    public int getEsp(){
        return this.esp;
    }

    /**
     * Altera a cor atual do primitivo
     *
     * @param corAtual cor atual do primitivo
     */
    public void setCorAtual(Color corAtual){
        this.corAtual = corAtual;
    }

    /**
     * retorna a cor atual do primitivo
     *
     * @return cor atual do primitivo
     */
    public Color getCorAtual(){
        return this.corAtual;
    }

    /**
     * Altera a msg a ser apresentada no rodape
     *
     * @param msg mensagem a ser apresentada
     */
    public void setMsg(JLabel msg){
        this.msg = msg;
    }

    /**
     * Retorna a mensagem
     *
     * @return mensagem as ser apresentada no rodape
     */
    public JLabel getMsg(){
        return this.msg;
    }

    /**
     * Metodo chamado quando o paint eh acionado
     *
     * @param g biblioteca para desenhar em modo grafico
     */
    public void paintComponent(Graphics g) {   
        desenharPrimitivos(g);
    }

    
    /**
     * Evento: pressionar do mouse
     *
     * @param e dados do evento
     */
    public void mousePressed(MouseEvent e) { 
        Graphics g = getGraphics();  
        if (tipo == TipoPrimitivo.PONTO){
            x = e.getX();
            y = e.getY();
            paint(g);
        } else if (tipo == TipoPrimitivo.RETA){

            if (primeiraVez == true) {
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            } else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
                paint(g);
            }
        } else if (tipo == TipoPrimitivo.RETANGULO){
            if(primeiraVez == true){
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            }
            else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
                paint(g);
            }
            
        } else if (tipo == TipoPrimitivo.MANDALA){
            if(primeiraVez == true){
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            }
            else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
                paint(g);
            }
            }
            else if (tipo == TipoPrimitivo.CIRCULO){
            if(primeiraVez == true){
                x1 = (int)e.getX();
                y1 = (int)e.getY();
                primeiraVez = false;
            }
            else {
                x2 = (int)e.getX();
                y2 = (int)e.getY();
                primeiraVez = true;
                paint(g);
            }
            }
            else if (tipo == TipoPrimitivo.TRIANGULO){
                if(primeiraVez == true){
                    a=1;
                    x1 = (int)e.getX();
                    y1 = (int)e.getY();
                    primeiraVez = false;
                    segundaVez = true;
                } else if(segundaVez==true) {
                    
                    x2 = (int)e.getX();
                    y2 = (int)e.getY();
                    primeiraVez = false;
                    segundaVez = false;
                    a++;
                }else{
                    x3 = (int)e.getX();
                    y3 = (int)e.getY();
                    primeiraVez = true;
                    segundaVez = false;
                    paint(g);                 
                }
            }else if (tipo == TipoPrimitivo.SELECIONAR) {
                x = (int)e.getX();
                y = (int)e.getY();
                paint(g);
            }
            else if (tipo == TipoPrimitivo.TRANSFORMACAO_GEOMETRICA) {
                x = (int)e.getX();
                y = (int)e.getY();
                paint(g);
            }// else if (tipo == TipoPrimitivo.ED_RECONSTRUIDA){
                // paint(g);
                // repaint();
             // }
    }     

    public void mouseReleased(MouseEvent e) { 
    }           

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Evento mouseMoved: escreve mensagem no rodape (x, y) do mouse
     *
     * @param e dados do evento do mouse
     */
    public void mouseMoved(MouseEvent e) {
        this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());
    }

    /**
     * Desenha os primitivos
     *
     * @param g biblioteca para desenhar em modo grafico
     */
    public void desenharPrimitivos(Graphics g){
        if (tipo == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g, x, y, "", getEsp(), getCorAtual());
            estrutura_de_dados.setTamanho(estrutura_de_dados.getTamanho()+1);
            FiguraPontos.ponto.setId(estrutura_de_dados.getTamanho());
            estrutura_de_dados.pontos.adicionarPonto(FiguraPontos.ponto);
            estrutura_de_dados.setUltimo("PONTO");
        }

        if (tipo == TipoPrimitivo.RETA){
            FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            estrutura_de_dados.setTamanho(estrutura_de_dados.getTamanho()+1);
            FiguraRetas.reta.setId(estrutura_de_dados.getTamanho());
            estrutura_de_dados.retas.adicionarReta(FiguraRetas.reta);
            estrutura_de_dados.setUltimo("RETA");
        }
        
        if (tipo == TipoPrimitivo.RETANGULO){
            FiguraRetangulos.desenharRetangulo(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            estrutura_de_dados.setTamanho(estrutura_de_dados.getTamanho()+1);
            FiguraRetangulos.retangulo.setId(estrutura_de_dados.getTamanho());
            estrutura_de_dados.retangulos.adicionarRetangulo(FiguraRetangulos.retangulo);
       estrutura_de_dados.setUltimo("RETANGULO");
        }
        
        if (tipo == TipoPrimitivo.TRIANGULO){
            FiguraTriangulos.desenharTriangulo(g, x1, y1, x2, y2, x3, y3, "", getEsp(), getCorAtual());
            estrutura_de_dados.setTamanho(estrutura_de_dados.getTamanho()+1);
            FiguraTriangulos.triangulo.setId(estrutura_de_dados.getTamanho());
            estrutura_de_dados.triangulos.adicionarTriangulo(FiguraTriangulos.triangulo);
          estrutura_de_dados.setUltimo("TRIANGULO");
        }

        if (tipo==TipoPrimitivo.CIRCULO){
            FiguraCirculos.desenharCirculo(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            estrutura_de_dados.setTamanho(estrutura_de_dados.getTamanho()+1);
            FiguraCirculos.circulo.setId(estrutura_de_dados.getTamanho());
            estrutura_de_dados.circulos.adicionarCirculo(FiguraCirculos.circulo);
       estrutura_de_dados.setUltimo("CIRCULO");
        }
        if (tipo==TipoPrimitivo.MANDALA){
            FiguraMandalas.desenharMandala(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            estrutura_de_dados.setTamanho(estrutura_de_dados.getTamanho()+1);
            FiguraMandalas.mandala.setId(estrutura_de_dados.getTamanho());
            estrutura_de_dados.mandalas.adicionarMandala(FiguraMandalas.mandala);
        estrutura_de_dados.setUltimo("MANDALA");
        }
        if (tipo==TipoPrimitivo.ED_RECONSTRUIDA){
            estrutura_de_dados.redesenhar(g);
            estrutura_de_dados.setUltimo("NENHUM");
        }
        if (tipo == TipoPrimitivo.SELECIONAR) {
            estrutura_de_dados.redesenhar(g);
            estrutura_de_dados.setUltimo("NENHUM");
        } 
        if (tipo == TipoPrimitivo.REMOVER_ULTIMO) {
            estrutura_de_dados.removerUltimaFigura();
            estrutura_de_dados.redesenhar(g);

        } 
        if (tipo == TipoPrimitivo.TRANSFORMACAO_GEOMETRICA) {
            //estrutura_de_dados.

        } 
        if (tipo == TipoPrimitivo.LEITURA) {
            // //this.lerArquivo(g);
            // estrutura_de_dados = new ArmazenadorPrincipal();
            // estrutura_de_dados.lerArmazenadorPrincipal(g);
            estrutura_de_dados.redesenhar(g);
            // JOptionPane.showMessageDialog(null, "Lido");
        } 
    }
    
    public void removeAll(){
         estrutura_de_dados = new ArmazenadorPrincipal();
    }
    
    public void salvarEstruturaDeDados(int largura, int altura){
        Gravador arquivo_salvo = new Gravador(estrutura_de_dados);
    }
    
    public void lerArquivo(Graphics g){
        estrutura_de_dados = new ArmazenadorPrincipal();
        estrutura_de_dados.lerArmazenadorPrincipal(g);
        //estrutura_de_dados.redesenhar(g);
    }
    
    
     // public void SelectFormas(Graphics g, int x, int y){
        
        // // ponto que foi clicado  
        // Ponto pontoaux = new Ponto(x, y);
        // PontoGr ponto = new PontoGr(x, y);
        // // seleção do ponto
        
            // if (edp.pontoMaisProximoDoPontoClicado(pontoaux == pontoaux)) {
                // if(indiceSelecionado != -1){
                    // deselecionarForma(g);
                // }
                // tipoSelecionado = "Ponto";
                // indiceSelecionado = edp.ArrayPonto.indexOf(ponto);
                // ponto.setCorPto(Color.RED);
                // ponto.desenharPonto(g);
                // this.msg.setText("ACHOU UM PONTO");
            // }
    // }
    
    // /**
     // * tira a seleçao da forma
     // * @param g - conteudo grafico
     // */
    // public void deselecionarForma(Graphics g){
        // switch (tipoSelecionado) {
            // // caso para apagar o objeto ponto
            // case "Ponto":
                // edp.ArrayPonto.get(indiceSelecionado).desenharPonto(g);
                // break;
        // }
        // indiceSelecionado = -1;
    // }
}
