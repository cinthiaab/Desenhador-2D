package ed;
import org.json.JSONArray;
import org.json.JSONObject;
import ponto.Ponto;
import ponto.PontoGr;
import reta.Reta;
import reta.RetaGr;
import reta.FiguraRetas;
import ponto.FiguraPontos;
import java.util.ArrayList;
import java.awt.*;

/**
 * Classe de estrutura de dados q utiliza lista para armazenar a informaçâo desejada
 * 
 * @author Cinthia Alves Barreto, Isabel Cavalcante Motta, Isabella Rubio Venancio
 * @version 14082023
 */
public class ArmazenadorRetas
{
    private ArrayList<RetaGr> ArrayReta;
    private int tamanho;

    public ArmazenadorRetas(){
        ArrayReta = new ArrayList<RetaGr>();
        setTamanho(0);
    }

    public void setTamanho(int tam){
        this.tamanho = tam;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void adicionarReta(RetaGr reta){
        int tam = getTamanho()+1;
        reta.setNomeReta("reta" + tam);
        ArrayReta.add(reta);
        setTamanho(tam);
    }

    int retaMaisProximoDoPontoClicado(PontoGr x){
        int idRetaMaisProximo = -1;
        double distancia=0;
        RetaGr reta;

        for(int i=0; i<getTamanho(); i++){
            reta = ArrayReta.get(i);
            if(i==0){
                distancia = reta.calcularDistancia(x); 
                idRetaMaisProximo = i;
            }
            else if(reta.calcularDistancia(x) < distancia){
                distancia = reta.calcularDistancia(x);
                idRetaMaisProximo = i;
            }
        }
        return idRetaMaisProximo;
    }

    public RetaGr buscar(int i){
        RetaGr reta = ArrayReta.get(i);
        return reta;
    }

    public void removerReta(int x){
        int tam = getTamanho() - 1;
        ArrayReta.remove(x);
        setTamanho(tam);
    }

    public String toString(){
        RetaGr reta;
        String txt = "\"reta\": [";
        for(int i=0; i<getTamanho(); i++){
            reta = ArrayReta.get(i);
            txt += reta.toString();
            if(i!=getTamanho()-1){
                txt += ",";
            }
        }
        txt += "]";

        return txt;
    }

    public JSONArray gravarRetasJson(int largura, int altura){
        JSONArray retaArray = new JSONArray();
        for (int i = 0; i<getTamanho(); i++){
            RetaGr r = buscar(i);
            JSONObject reta = new JSONObject();
            reta.put("id", "reta" + i);
            reta.put("espessura", r.getEspReta());
            reta.put("x1", r.getP1().getX()/largura);
            reta.put("y1", r.getP1().getY()/altura);
            reta.put("x2", r.getP2().getX()/largura);
            reta.put("y2", r.getP2().getY()/altura);
            JSONObject cor = new JSONObject();
            int blue = r.getCorReta().getBlue();
            int red = r.getCorReta().getRed();
            int green = r.getCorReta().getGreen();
            cor.put("r",red);
            cor.put("g",green);
            cor.put("b",blue);
            reta.put("cor"+ i, cor);

            retaArray.put(reta);

        }
        return retaArray;
    }

    public void lerRetasJson(JSONArray retaArray, int largura, int altura, Graphics ga){
        RetaGr reta_lido;
        FiguraRetas a = new FiguraRetas();
        String id_reta;
        int esp_reta;
        double x1, y1, x2, y2;

        for (int i = 0; i<retaArray.length(); i++){
            JSONObject reta = retaArray.getJSONObject(i);
            id_reta = reta.getString("id");
            esp_reta = reta.getInt("esp");
            JSONObject ponto1 = reta.getJSONObject("p1");
            x1 = ponto1.getDouble("x");
            y1 = ponto1.getDouble("y");
            JSONObject ponto2 = reta.getJSONObject("p2");
            x2 = ponto2.getDouble("x");
            y2 = ponto2.getDouble("y");

            JSONObject cor = reta.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");
            Color corReta = new Color(r, g, b);
            reta_lido = new RetaGr((int)(x1  * largura), (int)(y1 * altura), (int)(x2 * largura), (int)(y2 * altura), corReta, id_reta, esp_reta);
            FiguraRetas.desenharReta(ga, (int)(x1  * largura), (int)(y1 * altura), (int)(x2 * largura), (int)(y2 * altura), id_reta, esp_reta, corReta);

            adicionarReta(reta_lido);

        }

    }

    public void redesenharRetas(Graphics g){
        FiguraRetas x = new FiguraRetas();
        RetaGr reta;

        for(int i=0; i<getTamanho(); i++){
            reta = ArrayReta.get(i);
            x.desenharReta(g, reta);
        }
    }

    public void procurarId(int x){
        RetaGr reta;

        for(int i=0; i<getTamanho(); i++){
            reta = ArrayReta.get(i);

        }
    }

    public void removerUltimaReta(){
        int ult = getTamanho() - 1;
        ArrayReta.remove(ult);
        setTamanho(ult);
    }

    public void mudarCorRetas(Graphics g, Color cor){
        FiguraPontos x = new FiguraPontos();
        RetaGr reta;
        for(int i=0; i<getTamanho(); i++){
            reta = ArrayReta.get(i);
            x.mudarCorPonto(g, reta.getP1(), cor);
            x.mudarCorPonto(g, reta.getP2(), cor);
        }
    }
}
