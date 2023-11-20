package ed;
import ponto.Ponto;
import ponto.PontoGr;
import ponto.FiguraPontos;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe de estrutura de dados q utiliza lista para armazenar a informaçâo desejada
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class ArmazenadorPontos
{
    public ArrayList<PontoGr> ArrayPonto;
    private int tamanho;

    public ArmazenadorPontos(){
        ArrayPonto = new ArrayList<PontoGr>();
        setTamanho(0);
    }

    public void setTamanho(int tam){
        this.tamanho = tam;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void adicionarPonto(PontoGr ponto){
        int tam = getTamanho()+1;
        ponto.setNomePto("ponto" + tam);
        ArrayPonto.add(ponto);
        setTamanho(tam);
    }

    public JSONArray gravarPontosJson(int largura, int altura){
        JSONArray pontoArray = new JSONArray();
        for (int i = 0; i<getTamanho(); i++){
            PontoGr r = buscar(i);
            JSONObject ponto = new JSONObject();
            ponto.put("id", r.getNomePto());
            ponto.put("esp", r.getDiametro());
            ponto.put("x", r.getX()/largura);
            ponto.put("y", r.getY()/altura);

            JSONObject cor = new JSONObject();
            int blue = r.getCorPto().getBlue();
            int red = r.getCorPto().getRed();
            int green = r.getCorPto().getGreen();
            cor.put("r",red);
            cor.put("g",green);
            cor.put("b",blue);
            ponto.put("cor", cor);

            pontoArray.put(ponto);

        }
        return pontoArray;
    }

    public void lerPontosJson(JSONArray pontoArray, int largura, int altura, Graphics ga){
        PontoGr ponto_lido;
        String id_ponto;
        int esp_ponto;

        for (int i = 0; i<pontoArray.length(); i++){
            JSONObject ponto = pontoArray.getJSONObject(i);
            id_ponto = ponto.getString("id");
            esp_ponto = ponto.getInt("esp");
            double x = ponto.getDouble("x");
            double y =ponto.getDouble("y");

            
            JSONObject cor = ponto.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");
            Color corPonto = new Color(r, g, b);
            
            ponto_lido = new PontoGr((int)(x * largura), (int)(y * altura), corPonto, id_ponto, esp_ponto);
            FiguraPontos a = new FiguraPontos();
            a.desenharPonto(ga, (int)(x * largura), (int)(y * altura), id_ponto, esp_ponto, corPonto);
            
            adicionarPonto(ponto_lido);

        }
        
    }

    public int pontoMaisProximoDoPontoClicado(Ponto x){
        int idPontoMaisProximo = -1;
        double distancia=0;
        PontoGr ponto;

        for(int i=0; i<getTamanho(); i++){
            ponto = ArrayPonto.get(i);
            if(i==0){distancia = ponto.calcularDistancia(x); }
            else if(ponto.calcularDistancia(x) < distancia){
                distancia = ponto.calcularDistancia(x);
            }
        }
        return idPontoMaisProximo;
    }

    public PontoGr buscar(int i){
        PontoGr ponto = ArrayPonto.get(i);
        return ponto;
    }

    public void removerPonto(int x){
        int tam = getTamanho()-1;
        ArrayPonto.remove(x);
        setTamanho(tam);
    }
    
    public void removerUltimoPonto(){
        int ult = getTamanho() - 1;

        ArrayPonto.remove(ult);
        setTamanho(ult);
    
    }

    public String toString(){
        PontoGr ponto;
        String txt = "\"ponto\": ]";
        for(int i=0; i<getTamanho(); i++){
            ponto = ArrayPonto.get(i);
            txt = ponto.toString();

        }
        txt = "]";

        return txt;
    }

    public void redesenharPontos(Graphics g){
        FiguraPontos x = new FiguraPontos();
        PontoGr ponto;

        for(int i=0; i<getTamanho(); i++){
            ponto = ArrayPonto.get(i);
            x.desenharPonto(g, ponto);
        }
    }
    // public void redesenharPontos(Graphics g, Color cor){
    // FiguraPontos x = new FiguraPontos();
    // PontoGr ponto;

    // for(int i=0; i<getTamanho(); i++){
    // ponto = ArrayPonto.get(i);
    // ponto.setCorPto(cor);     
    // x.desenharPonto(g, ponto);
    // }
    // }
}