package ed;
import ponto.Ponto;
import mandala.Mandala;
import mandala.MandalaGr;
import mandala.FiguraMandalas;
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
public class ArmazenadorMandalas
{
    private ArrayList<MandalaGr> ArrayMandala;
    private int tamanho;
    
    public ArmazenadorMandalas(){
        ArrayMandala = new ArrayList<MandalaGr>();
        setTamanho(0);
    }
    public void setTamanho(int tam){
        this.tamanho = tam;
    }
    public int getTamanho(){
        return tamanho;
    }
    public void adicionarMandala(MandalaGr mandala){
        int tam = getTamanho()+1;
        mandala.setNome("mandala" + tam);
        ArrayMandala.add(mandala);
        setTamanho(getTamanho()+1);
    }
    int mandalaMaisProximoDoPontoClicado(Ponto x){
        int idMandalaMaisProximo = -1;
        double distancia = 0;
        MandalaGr mandala;
        
        for(int i=0; i<getTamanho(); i++){
            mandala = ArrayMandala.get(i);
            if(i==0){distancia = mandala.calcularDistancia(x); }
            else if(mandala.calcularDistancia(x) < distancia){
                distancia = mandala.calcularDistancia(x);
            }
        }
        return idMandalaMaisProximo;
    }
    
    public JSONArray gravarMandalasJson(int largura, int altura){
        JSONArray mandalaArray = new JSONArray();
        for (int i = 0; i<getTamanho(); i++){
                MandalaGr r = buscar(i);
                JSONObject mandala = new JSONObject();
                mandala.put("id", r.getNome());
                mandala.put("esp", r.getDiametro());
                
                JSONObject ponto1 = new JSONObject();
                ponto1.put("x", r.getP1().getX()/largura);
                ponto1.put("y", r.getP1().getY()/altura);
                JSONObject ponto2 = new JSONObject();
                ponto2.put("x", r.getP2().getX()/largura);
                ponto2.put("y", r.getP2().getY()/altura);
                mandala.put("p1", ponto1);
                mandala.put("p2", ponto2);
                
                JSONObject cor1 = new JSONObject();
                int blue = r.getCor1().getBlue();
                int red = r.getCor1().getRed();
                int green = r.getCor1().getGreen();
                cor1.put("r",red);
                cor1.put("g",green);
                cor1.put("b",blue);
                mandala.put("cor1", cor1);
                
                JSONObject cor2 = new JSONObject();
                blue = r.getCor2().getBlue();
                red = r.getCor2().getRed();
                green = r.getCor2().getGreen();
                cor2.put("r",red);
                cor2.put("g",green);
                cor2.put("b",blue);
                mandala.put("cor2", cor2);
                
                mandalaArray.put(mandala);
                
        }
        return mandalaArray;
    }
    
    public void removerMandala(int x){
        int tam = getTamanho() - 1;
        ArrayMandala.remove(x);
        setTamanho(tam);
    }
    
    public void removerUltimaMandala(){
        int ult = getTamanho() - 1;
        ArrayMandala.remove(ult);
        setTamanho(ult);

    }
    
    public void lerMandalasJson(JSONArray mandalaArray, int largura, int altura, Graphics ga){
        MandalaGr mandala_lido;
        String id_mandala;
        int esp_mandala;
        double x1, y1, x2, y2;

        for (int i = 0; i<mandalaArray.length(); i++){
            JSONObject mandala = mandalaArray.getJSONObject(i);
            id_mandala = mandala.getString("id");
            esp_mandala = mandala.getInt("esp");
            JSONObject ponto1 = mandala.getJSONObject("p1");
            x1 = ponto1.getDouble("x");
            y1 = ponto1.getDouble("y");
            JSONObject ponto2 = mandala.getJSONObject("p2");
            x2 = ponto2.getDouble("x");
            y2 = ponto2.getDouble("y");

            JSONObject cor = mandala.getJSONObject("cor1");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");
            Color corMandala1 = new Color(r, g, b);
            JSONObject cor2 = mandala.getJSONObject("cor2");
            r = cor2.getInt("r");
            g = cor2.getInt("g");
            b = cor2.getInt("b");
            Color corMandala2 = new Color(r, g, b);
            
            mandala_lido = new MandalaGr((int)x1 * largura, (int)y1 * altura, (int)x2 * largura, (int)y2 * altura, corMandala1, corMandala2, id_mandala, esp_mandala);
            FiguraMandalas a = new FiguraMandalas();
            a.desenharMandala(ga, (int)x1 * largura, (int)y1 * altura, (int)x2 * largura, (int)y2 * altura, id_mandala, esp_mandala, corMandala1);
            adicionarMandala(mandala_lido);

        }
        
    }
    public String toString(){
        MandalaGr mandala;
        String txt = "\"mandala\": ]";
        for(int i=0; i<getTamanho(); i++){
            mandala = ArrayMandala.get(i);
            txt = mandala.toString();
        }
        txt = "]";
        
        return txt;
    }
    
    public MandalaGr buscar(int i){
        MandalaGr mandala = ArrayMandala.get(i);
        return mandala;
    }
    
    public void redesenharMandalas(Graphics g){
        FiguraMandalas x = new FiguraMandalas();
        MandalaGr mandala;
        
        for(int i=0; i<getTamanho(); i++){
            mandala= ArrayMandala.get(i);
            x.desenharMandala(g, mandala);
        }
    }
}
