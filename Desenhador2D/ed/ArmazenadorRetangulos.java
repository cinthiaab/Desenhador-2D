package ed;
import ponto.Ponto;
import retangulo.Retangulo;
import retangulo.RetanguloGr;
import retangulo.FiguraRetangulos;
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
public class ArmazenadorRetangulos
{
    private ArrayList<RetanguloGr> ArrayRetangulo;
    private int tamanho;
    
    public ArmazenadorRetangulos(){
        ArrayRetangulo = new ArrayList<RetanguloGr>();
        setTamanho(0);
    }
    public void setTamanho(int tam){
        this.tamanho = tam;
    }
    public int getTamanho(){
        return tamanho;
    }
    public void adicionarRetangulo(RetanguloGr retangulo){
        int tam = getTamanho()+1;
        retangulo.setNomeRetangulo("retangulo" + tam);
        ArrayRetangulo.add(retangulo);
        setTamanho(tam);
    }
    
    public JSONArray gravarRetangulosJson(int largura, int altura){
        JSONArray retanguloArray = new JSONArray();
        for (int i = 0; i<getTamanho(); i++){
                RetanguloGr r = buscar(i);
                JSONObject retangulo = new JSONObject();
                
                retangulo.put("id", r.getNomeRetangulo());
                retangulo.put("esp", r.getDiametro());
                
                JSONObject ponto1 = new JSONObject();
                ponto1.put("x", r.getP1().getX()/largura);
                ponto1.put("y", r.getP1().getY()/altura);
                JSONObject ponto2 = new JSONObject();
                ponto2.put("x", r.getP2().getX()/largura);
                ponto2.put("y", r.getP2().getY()/altura);
                retangulo.put("p1", ponto1);
                retangulo.put("p2", ponto2);
                
                JSONObject cor = new JSONObject();
                int blue = r.getCorRetangulo().getBlue();
                int red = r.getCorRetangulo().getRed();
                int green = r.getCorRetangulo().getGreen();
                cor.put("r",red);
                cor.put("g",green);
                cor.put("b",blue);
                retangulo.put("cor", cor);
                
                retanguloArray.put(retangulo);
                
        }
        return retanguloArray;
    }
    
    public void lerRetangulosJson(JSONArray retanguloArray, int largura, int altura, Graphics ga){
        RetanguloGr retangulo_lido;
        String id_retangulo;
        int esp_retangulo;
        double x1, y1, x2, y2;

        for (int i = 0; i<retanguloArray.length(); i++){
            JSONObject retangulo = retanguloArray.getJSONObject(i);
            id_retangulo = retangulo.getString("id");
            esp_retangulo = retangulo.getInt("esp");
            JSONObject ponto1 = retangulo.getJSONObject("p1");
            x1 = ponto1.getDouble("x");
            y1 = ponto1.getDouble("y");
            JSONObject ponto2 = retangulo.getJSONObject("p2");
            x2 = ponto2.getDouble("x");
            y2 = ponto2.getDouble("y");

            JSONObject cor = retangulo.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");
            Color corRetangulo = new Color(r, g, b);
            
            retangulo_lido = new RetanguloGr((int)x1 * largura, (int)y1 * altura, (int)x2 * largura, (int)y2 * altura, corRetangulo, id_retangulo, esp_retangulo);
            FiguraRetangulos a = new FiguraRetangulos();
            a.desenharRetangulo(ga, (int)x1 * largura, (int)y1 * altura, (int)x2 * largura, (int)y2 * altura, id_retangulo, esp_retangulo, corRetangulo);
            adicionarRetangulo(retangulo_lido);

        }
        
    }
    int retanguloMaisProximoDoPontoClicado(Ponto x){
        int idRetanguloMaisProximo = -1;
        double distancia=0;
        RetanguloGr retangulo;
        
        for(int i=0; i<getTamanho(); i++){
            retangulo = ArrayRetangulo.get(i);
            if(i==0){distancia = retangulo.calcularDistancia(x); }
            else if(retangulo.calcularDistancia(x) < distancia){
                distancia = retangulo.calcularDistancia(x);
            }
        }
        return idRetanguloMaisProximo;
    }
    
    public String toString(){
        RetanguloGr retangulo;
        String txt = "\"retangulo\": ]";
        for(int i=0; i<getTamanho(); i++){
            retangulo = ArrayRetangulo.get(i);
            txt = retangulo.toString();
        }
        txt = "]";
        
        return txt;
    }
    
    public RetanguloGr buscar(int i){
        RetanguloGr retangulo = ArrayRetangulo.get(i);
        return retangulo;
    }
    
    public void removerRetangulo(int x){
        int tam = getTamanho() - 1;
        ArrayRetangulo.remove(x);
        setTamanho(tam);
    }
    
    public void removerUltimoRetangulo(){
        int ult = getTamanho() - 1;
    
        ArrayRetangulo.remove(ult);
        setTamanho(ult);
        
    }
    
    public void redesenharRetangulos(Graphics g){
        FiguraRetangulos x = new FiguraRetangulos();
        RetanguloGr retangulo;
        
        for(int i=0; i<getTamanho(); i++){
            retangulo = ArrayRetangulo.get(i);
            x.desenharRetangulo(g, retangulo);
        }
    }
}
