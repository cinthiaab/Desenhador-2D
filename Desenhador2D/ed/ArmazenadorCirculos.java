package ed;
import ponto.Ponto;
import circulo.Circulo;
import circulo.CirculoGr;
import circulo.FiguraCirculos;
import java.util.ArrayList;
import java.awt.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe de estrutura de dados q utiliza lista para armazenar a informaçâo desejada
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class ArmazenadorCirculos
{
    private ArrayList<CirculoGr> ArrayCirculo;
    private int tamanho;

    public ArmazenadorCirculos(){
        ArrayCirculo = new ArrayList<CirculoGr>();
        setTamanho(0);
    }

    public void setTamanho(int tam){
        this.tamanho = tam;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void adicionarCirculo(CirculoGr circulo){
        int tam = getTamanho()+1;
        circulo.setNomeCirculo("circulo" + tam);
        ArrayCirculo.add(circulo);
        setTamanho(getTamanho()+1);
    }
    
    public void removerUltimoCirculo(){
        int ult = getTamanho() - 1;
        ArrayCirculo.remove(ult);
        setTamanho(ult);
    }
    
     public void removerCirculo(int x){
        int tam = getTamanho() - 1;
        ArrayCirculo.remove(x);
        setTamanho(tam);
    }

    int circuloMaisProximoDoPontoClicado(Ponto x){
        int idCirculoMaisProximo = -1;
        double distancia=0;
        CirculoGr circulo;

        for(int i=0; i<getTamanho(); i++){
            circulo = ArrayCirculo.get(i);
            if(i==0){distancia = circulo.calcularDistancia(x); }
            else if(circulo.calcularDistancia(x) < distancia){
                distancia = circulo.calcularDistancia(x);
            }
        }
        return idCirculoMaisProximo;
    }

    public JSONArray gravarCirculosJson(int largura, int altura){
        JSONArray circuloArray = new JSONArray();
        for (int i = 0; i<getTamanho(); i++){
            CirculoGr r = buscar(i);
            JSONObject circulo = new JSONObject();
            circulo.put("id", r.getNomeCirculo());
            circulo.put("esp", r.getDiametro());

            JSONObject ponto = new JSONObject();
            ponto.put("x", r.getP1().getX()/largura);
            ponto.put("y", r.getP1().getY()/altura);
            circulo.put("centro", ponto);
            circulo.put("raio", r.getRaio());

            JSONObject cor = new JSONObject();
            int blue = r.getCorCirculo().getBlue();
            int red = r.getCorCirculo().getRed();
            int green = r.getCorCirculo().getGreen();
            cor.put("r",red);
            cor.put("g",green);
            cor.put("b",blue);
            circulo.put("cor", cor);

            circuloArray.put(ponto);

        }
        return circuloArray;
    }

    public void lerCirculosJson(JSONArray circuloArray, int largura, int altura, Graphics ga){
        double x, y, raio;
        CirculoGr circulo_lido;
        String id_circulo;
        int r, g, b, esp_circulo;

        for (int i = 0; i<circuloArray.length(); i++){
            
            JSONObject circulo = circuloArray.getJSONObject(i);
            id_circulo = circulo.getString("id");
            esp_circulo = circulo.getInt("esp");
            JSONObject ponto = circulo.getJSONObject("centro");
            x = ponto.getDouble("x");
            y =ponto.getDouble("y");
            raio = circulo.getDouble("raio");
            JSONObject cor = circulo.getJSONObject("cor");
            r = cor.getInt("r");
            g = cor.getInt("g");
            b = cor.getInt("b");
            Color corCirculo = new Color(r, g, b);

            circulo_lido = new CirculoGr((int)(x * largura), (int)(y * altura), (int)(raio * largura), corCirculo, id_circulo, esp_circulo);
            FiguraCirculos a = new FiguraCirculos();
            a.desenharCirculo(ga, (int)(x * largura), (int)(y * altura), (int)(raio * largura), id_circulo, esp_circulo, corCirculo);
            
            adicionarCirculo(circulo_lido);
        }
    }

    public String toString(){
        CirculoGr circulo;
        String txt = "\"circulo\": ]";
        for(int i=0; i<getTamanho(); i++){
            circulo = ArrayCirculo.get(i);
            txt = circulo.toString();
        }
        txt = "]";

        return txt;
    }

    public CirculoGr buscar(int i){
        CirculoGr circulo = ArrayCirculo.get(i);
        return circulo;
    }

    public void redesenharCirculos(Graphics g){
        FiguraCirculos x = new FiguraCirculos();
        CirculoGr circulo;

        for(int i=0; i<getTamanho(); i++){
            circulo = ArrayCirculo.get(i);
            x.desenharCirculo(g, circulo);
        }
    }
}
