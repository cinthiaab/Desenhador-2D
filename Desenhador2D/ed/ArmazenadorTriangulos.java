package ed;

import ponto.Ponto;
import triangulo.Triangulo;
import triangulo.TrianguloGr;
import triangulo.FiguraTriangulos;
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
public class ArmazenadorTriangulos
{
    private ArrayList<TrianguloGr> ArrayTriangulo;
    private int tamanho;

    public ArmazenadorTriangulos(){
        ArrayTriangulo = new ArrayList<TrianguloGr>();
        setTamanho(0);
    }

    public void setTamanho(int tam){
        this.tamanho = tam;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void adicionarTriangulo(TrianguloGr triangulo){
        int tam = getTamanho()+1;
        triangulo.setNomeTriangulo("triangulo" + tam);
        ArrayTriangulo.add(triangulo);
        setTamanho(getTamanho()+1);
    }
    
    public void rotacionarTriangulo(Graphics g, int i, int xq, int yq){
        
    }

    public int trianguloMaisProximoDoPontoClicado(Ponto x){
        int idTrianguloMaisProximo = -1;
        double distancia=0;
        TrianguloGr triangulo;

        for(int i=0; i<getTamanho(); i++){
            triangulo = ArrayTriangulo.get(i);
            if(i==0){distancia = triangulo.calcularDistancia(x); }
            else if(triangulo.calcularDistancia(x) < distancia){
                distancia = triangulo.calcularDistancia(x);
            }
        }
        return idTrianguloMaisProximo;
    }
    
    public JSONArray gravarTriangulosJson(int largura, int altura){
        JSONArray trianguloArray = new JSONArray();
        for (int i = 0; i<getTamanho(); i++){
                TrianguloGr r = buscar(i);
                JSONObject triangulo = new JSONObject();
                
                triangulo.put("id", r.getNomeTriangulo());
                triangulo.put("esp", r.getDiametro());
                
                JSONObject ponto1 = new JSONObject();
                ponto1.put("x", r.getP1().getX()/largura);
                ponto1.put("y", r.getP1().getY()/altura);
                JSONObject ponto2 = new JSONObject();
                ponto2.put("x", r.getP2().getX()/largura);
                ponto2.put("y", r.getP2().getY()/altura);
                triangulo.put("p1", ponto1);
                triangulo.put("p2", ponto2);
                JSONObject ponto3 = new JSONObject();
                ponto3.put("x", r.getP3().getX()/largura);
                ponto3.put("y", r.getP3().getY()/altura);
                triangulo.put("p1", ponto1);
                triangulo.put("p2", ponto2);
                triangulo.put("p3", ponto3);
                
                JSONObject cor = new JSONObject();
                int blue = r.getCorTriangulo().getBlue();
                int red = r.getCorTriangulo().getRed();
                int green = r.getCorTriangulo().getGreen();
                cor.put("r",red);
                cor.put("g",green);
                cor.put("b",blue);
                triangulo.put("cor", cor);
                
                trianguloArray.put(triangulo);
        }
        return trianguloArray;
    }
    
    public void removerTriangulo(int x){
        int tam = getTamanho() - 1;
        ArrayTriangulo.remove(x);
        setTamanho(tam);
    }
    
    public void removerUltimoTriangulo(){
        int ult = getTamanho() - 1;
        ArrayTriangulo.remove(ult);
        setTamanho(ult);

    }
    
    public void lerTriangulosJson(JSONArray trianguloArray, int largura, int altura, Graphics ga){
        TrianguloGr triangulo_lido;
        FiguraTriangulos a;
        String id_triangulo;
        int esp_triangulo;
        double x1, y1, x2, y2, x3, y3;

        for (int i = 0; i<trianguloArray.length(); i++){
            JSONObject triangulo = trianguloArray.getJSONObject(i);
            id_triangulo = triangulo.getString("id");
            esp_triangulo = triangulo.getInt("esp");
            JSONObject ponto1 = triangulo.getJSONObject("p1");
            x1 = ponto1.getDouble("x");
            y1 = ponto1.getDouble("y");
            JSONObject ponto2 = triangulo.getJSONObject("p2");
            x2 = ponto2.getDouble("x");
            y2 = ponto2.getDouble("y");
            JSONObject ponto3 = triangulo.getJSONObject("p3");
            x3 = ponto2.getDouble("x");
            y3 = ponto2.getDouble("y");

            JSONObject cor = triangulo.getJSONObject("cor");
            int r = cor.getInt("r");
            int g = cor.getInt("g");
            int b = cor.getInt("b");
            Color corTriangulo = new Color(r, g, b);
            a = new FiguraTriangulos();

            triangulo_lido = new TrianguloGr((int)x1  * largura, (int)y1 * altura, (int)x2 * largura, (int)y2 * altura, (int)x3 * largura, (int)y3 * altura, corTriangulo, id_triangulo, esp_triangulo);
            a.desenharTriangulo(ga, (int)x1  * largura, (int)y1 * altura, (int)x2 * largura, (int)y2 * altura, (int)x3 * largura, (int)y3 * altura, id_triangulo, esp_triangulo, corTriangulo);
            adicionarTriangulo(triangulo_lido);

        }
        
    }
    public String toString(){
        TrianguloGr triangulo;
        String txt = "\"triangulo\": ]";
        for(int i=0; i<getTamanho(); i++){
            triangulo = ArrayTriangulo.get(i);
            txt = triangulo.toString();
        }
        txt = "]";

        return txt;
    }

    public TrianguloGr buscar(int i){
        TrianguloGr triangulo = ArrayTriangulo.get(i);
        return triangulo;
    }

    public void redesenharTriangulos(Graphics g){
        FiguraTriangulos x = new FiguraTriangulos();
        TrianguloGr triangulo;

        for(int i=0; i<getTamanho(); i++){
            triangulo = ArrayTriangulo.get(i);
            x.desenharTriangulo(g, triangulo);
        }
    }
}
