import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    //Meus queridos #define ai embaixo
    public static int REGIAO = 0;
    public static int ESTADO = 1;
    public static int MUNICIPIO = 2;
    public static int CODUF = 3;
    public static int CODMUN = 4;
    public static int CODREGIAOSAUDE = 5;
    public static int NOMEREGIAOSAUDE = 6;
    public static int DATA = 7;
    public static int SEMANAEPI = 8;
    public static int POPULACAOTCU2019 = 9;
    public static int CASOSACUMULADO = 10;
    public static int CASOSNOVOS = 11;
    public static int OBITOSACUMULADO = 12;
    public static int OBITOSNOVOS = 13;
    public static int RECUPERADOSNOVOS = 14;
    public static int EMACOMPANHAMENTONOVOS = 15;
    public static int INTERIOR = 16;
    public static String path1 = System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv";
    public static String path2 = System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv";
    public static String path3 = System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv";
    public static String path4 = System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv";
    public static String split = ";";


    public static void main(String[] args) {
        String line = "";

        ArvoreBB arvorebb = new ArvoreBB();
        ArvoreAVL arvoreavl = new ArvoreAVL();

        try {
            //Leitor de arquivo
            BufferedReader br = new BufferedReader(new FileReader(path4));
            //Roda ate achar a ultima linha
            while ((line = br.readLine()) != null) {
                //Guarda os dados na variavel employee, a gente vai fazer um sistema pra pegar os dados e jogar no objeto Dados da classe No
                String[] employee = line.split(split);
                try {
                    //Printa todos os dados de determinada linha, usem isso para testar o print
                    System.out.println(employee[OBITOSACUMULADO]); //COMENTA ESSA LINHA SE TIVER TRAVANDO MUITO ----------------------------------------
                    //Pra os casos onde estiver em espaço branco
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Ao inves de continue, vai adcionar o valor null no objeto
                    continue;
                }
            }
            //Esse catch nunca vai dar erro porque eu fiz o sistema responsivo hehe :3
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //Esse daqui eu nem lembro, mas deixa ai.
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Rodou o programa ate o final
        System.out.println("Funcionou!");
    }
}
