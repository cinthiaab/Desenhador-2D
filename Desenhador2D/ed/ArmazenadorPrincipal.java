package ed;
import org.json.JSONArray;
import org.json.JSONObject;
import ponto.Ponto;
import ponto.PontoGr;
import ponto.FiguraPontos;
import reta.RetaGr;
import reta.FiguraRetas;
import triangulo.TrianguloGr;
import triangulo.FiguraTriangulos;
import retangulo.RetanguloGr;
import retangulo.FiguraRetangulos;
import mandala.MandalaGr;
import mandala.FiguraMandalas;
import circulo.CirculoGr;
import circulo.FiguraCirculos;
import java.awt.Graphics;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Escreva uma descrição da classe ArmazenadorPrincipal aqui.
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version (um número da versão ou uma data)
 */
public class ArmazenadorPrincipal
{
    public ArmazenadorPontos pontos;
    public ArmazenadorRetas retas;
    public ArmazenadorRetangulos retangulos;
    public ArmazenadorTriangulos triangulos;
    public ArmazenadorCirculos circulos;
    public ArmazenadorMandalas mandalas;
    public int altura, largura; 
    private int tamanho;
    public String ultimo = "NENHUM";

    public ArmazenadorPrincipal()
    {
        this.altura = 1300;
        this.largura = 1000;
        pontos = new ArmazenadorPontos();
        retas = new ArmazenadorRetas();
        retangulos = new ArmazenadorRetangulos();
        triangulos = new ArmazenadorTriangulos();
        circulos = new ArmazenadorCirculos();
        mandalas = new ArmazenadorMandalas();
        setTamanho(0);
    }
    
    public void setUltimo(String ult){
        this.ultimo = ult;
    }

    public void setAltura(int a){
        this.altura = a;
    }

    public void setLargura(int l){
        this.largura = l;
    }

    public double getAltura(){
        return this.altura;
    }

    public double getLargura(){
        return this.largura;
    }

    public void setTamanho(int tam){
        this.tamanho = tam;
    }

    public int getTamanho(){
        return tamanho;
    }
    
    public void removerUltimaFigura(){
        switch(ultimo){
            case "PONTO":
                pontos.removerUltimoPonto();
                setUltimo("NENHUM");
            break;
            case "RETA":
                retas.removerUltimaReta();
                setUltimo("NENHUM");
            break;
            case "RETANGULO":
                retangulos.removerUltimoRetangulo();
                setUltimo("NENHUM");
            break;  
            case "TRIANGULO":
                triangulos.removerUltimoTriangulo();
                setUltimo("NENHUM");
            break;   
            case "CIRCULO":
                circulos.removerUltimoCirculo();
                setUltimo("NENHUM");
            break;    
            case "MANDALA":
                mandalas.removerUltimaMandala();
                setUltimo("NENHUM");
            break;
            case "NENHUM":
                JOptionPane.showMessageDialog(null,"Erro, nao e possivel usar o Ctrl Z mais de uma vez!");
            break;
        }
    }

    public int figuraMaisProximaDoPonto(Ponto p){
        int id=0;
        if(getTamanho()>0){
            //if(pontos.calcularDistancia()
        }
        return id;
    }

    public void selecionar(PontoGr x){
        int id_removido;
        id_removido = retas.retaMaisProximoDoPontoClicado(x);
        retas.removerReta(id_removido);

    }

    public void redesenhar(Graphics g){
        pontos.redesenharPontos(g);
        retas.redesenharRetas(g);
        retangulos.redesenharRetangulos(g);
        triangulos.redesenharTriangulos(g);
        circulos.redesenharCirculos(g);
        mandalas.redesenharMandalas(g);
    }
    
    public JSONObject gravarArmazenadorPrincipal(){

        JSONObject desenho = new JSONObject();
        desenho.put("ponto", pontos.gravarPontosJson(largura, altura));
        desenho.put("reta", retas.gravarRetasJson(largura, altura));
        desenho.put("triangulo", triangulos.gravarTriangulosJson(largura, altura));
        desenho.put("retangulo", retangulos.gravarRetangulosJson(largura, altura));
        desenho.put("circulo", circulos.gravarCirculosJson(largura, altura));
        desenho.put("mandala", mandalas.gravarMandalasJson(largura, altura));

        return desenho;
    }

    public void lerArmazenadorPrincipal(Graphics g){
        File arquivo = null;
        BufferedReader br = null;
        FileReader fr = null;

        String nomeArq;
        //arquivo = new File("C:/Users/ra00325161/Downloads/exemplo.json");
        arquivo = new File("teste.json");
        if (!arquivo.exists()) { //testa para ver se o arquivo existe
            JOptionPane.showInputDialog("Arquivo inexistente");
        }

        String teste1 = "";
        String teste = "";
        try {
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);

            while ((teste1 = br.readLine()) != null){
                teste += teste1;
                System.out.println(teste1);
            }
            br.close();

        } catch(FileNotFoundException ex) {
            JOptionPane.showInputDialog("Arquivo inexistente:");
        } catch(Exception ex) {
            JOptionPane.showInputDialog("Erro inesperado ao tentar abrir o arquivo: ");
            ex.printStackTrace();
        }

        JSONObject jObj = new JSONObject(teste);
        JSONObject desenho = jObj.getJSONObject("desenho");
        

        pontos.lerPontosJson(desenho.getJSONArray("ponto"), largura, altura, g);
        retas.lerRetasJson(desenho.getJSONArray("reta"), largura, altura, g);
        triangulos.lerTriangulosJson(desenho.getJSONArray("triangulo"), largura, altura, g);
        retangulos.lerRetangulosJson(desenho.getJSONArray("retangulo"), largura, altura, g);
        circulos.lerCirculosJson(desenho.getJSONArray("circulo"), largura, altura, g);
        mandalas.lerMandalasJson(desenho.getJSONArray("mandala"), largura, altura, g);
        System.out.println("Leitura feita com sucesso");
    }

    public String toString(){
        String txt = "";
        txt += pontos.toString();
        txt += retas.toString();
        txt += retangulos.toString();
        txt += triangulos.toString();
        txt += circulos.toString();
        txt += mandalas.toString();
        return txt;
    }
}
