import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class Menu {
    private final static int idArvoreBB = 0;
    private final static int idArvoreAVL = 1;
    private static int contadorPesquisa = 1;
    private static int indiceLinha = 0;
    private static String matriz[][];
    private static Arvore[] Floresta = new Arvore[2];
    private static TipoNo no;
    private static int travaOp = 0;
    private static int travaOpRegiao = 0;
    private static String lastDate;
    public static int op;
    public static int opcaoRegiao;
    public static String chaveMenu;
    public static int[][] regiaoBB;
    public static int[][] regiaoAVL;

    public static void Start() {
        MostrarMenu();
    }

    public static void MostrarMenu() {
        op = Integer.parseInt(
                JOptionPane.showInputDialog("    Menu    \n1 - Inicializar  \n2 - Creditos \n3 - Sobre \n4 - Sair"));

        switch (op) {
            case 1:
                if (travaOp++ == 0) {
                    try {
                        Loading();
                    } catch (FileNotFoundException e) {
                        System.out.println("Ocorreu um erro gravissimo!!!!!!!!!!");
                        Sair();
                    }
                    CriaFloresta();
                    ApagaMatriz();
                }
                Inicializar();
                break;
            case 2:
                Creditos();
                break;
            case 3:
                Sobre();
                break;
            case 4:
                Sair();
                break;

            default:
                break;
        }

    }

    private static void Loading() throws FileNotFoundException {
        String[] path = { System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv",
                System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv",
                System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv",
                System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv" };

        lastDate = Arquivo.PegaLastDate(path[3]);

        System.out.println("Calculando area do terreno...");

        int quantidadeDeColunas = 10, quantidadeDeLinhas = 0;

        for (int i = 0; i < 4; i++) {
            quantidadeDeLinhas = Arquivo.ContaLinhas(path[i], quantidadeDeLinhas);
        }

        System.out.println("Tirando leite da vaca...");
        matriz = new String[quantidadeDeLinhas][quantidadeDeColunas];

        indiceLinha = 0;
        for (int i = 0; i < 4; i++) {
            indiceLinha = Arquivo.PreencheMatriz(path[i], matriz, indiceLinha, quantidadeDeColunas);
        }

        System.out.println("Selecionando sementes geneticamente modificadas...");
        Arquivo.QuickSort(matriz, 0, indiceLinha - 1);
    }

    private static void Sair() {
        System.exit(0);
    }

    private static void Sobre() {
        System.out.println(
                "Programa para consultas em arvore binária e AVL sobre os dados do covid19." + "\n Forma de Usar"
                        + "\nÉ porssível consultar dados de qualquer região através do codmun ou coduf seguido da data"
                        + "\nAlém disso existe ");
        MostrarMenu();
    }

    private static void Creditos() {
        System.out.println("Ericles Santos - bit.ly/ericlessc");
        System.out.println("Kendy Ferreira - ");
        System.out.println("Joanne Stephany - ");
        System.out.println("Maria Milena");
        System.out.println("Pedro William - ");
        System.out.println("Thiago Santos - bit.ly/xxthiagoboyxx");

        MostrarMenu();
    }

    private static void Inicializar() {
        op = Integer.parseInt(JOptionPane.showInputDialog(
                "    Menu    \n1 - Dados por codmun/coduf e data  \n2 - Obitos e casos totais por cidade \n3 - Obitos e casos totais por região \n4 - Obitos e casos totais do Brasil \n0 - Voltar"));

        switch (op) {
            case 0:
                MostrarMenu();
            case 1:
                chaveMenu = JOptionPane.showInputDialog("Digite o codmun ou coduf");
                chaveMenu += JOptionPane.showInputDialog("Digite ano") + "-";
                chaveMenu += JOptionPane.showInputDialog("Digite mês") + "-";
                chaveMenu += JOptionPane.showInputDialog("Digite o dia");

                System.out.println("Pesqusisa na Arvore Binaria:");
                no = Floresta[idArvoreBB].Pesquisa(chaveMenu);
                contadorPesquisa = Floresta[idArvoreBB].Consultas(chaveMenu);
                Floresta[idArvoreBB].contadorPesquisa = 1;

                if (no == null)
                    System.out.println("Não encontramos essa folha.");
                else {
                    System.out.println(no.dados.toString());
                    System.out.println(contadorPesquisa);
                }

                System.out.println("Pesqusisa na Arvore AVL:");
                no = Floresta[idArvoreAVL].Pesquisa(chaveMenu);
                contadorPesquisa = Floresta[idArvoreAVL].Consultas(chaveMenu);
                Floresta[idArvoreAVL].contadorPesquisa = 1;

                if (no == null)
                    System.out.println("Não encontramos essa folha.");
                else {
                    System.out.println(no.dados.toString());
                    System.out.println(contadorPesquisa);
                }
                MostrarMenu();

                break;
            case 2:
                chaveMenu = JOptionPane.showInputDialog("Digite o codmun ou coduf") + lastDate;
                System.out.println("Pesqusisa na Arvore Binaria:");
                no = Floresta[idArvoreBB].Pesquisa(chaveMenu);
                contadorPesquisa = Floresta[idArvoreBB].Consultas(chaveMenu);
                Floresta[idArvoreBB].contadorPesquisa = 1;

                if (no == null)
                    System.out.println("Não encontramos essa folha.");
                else {
                    System.out.println("Casos Acumulados: " + no.dados.casosAcumulados);
                    System.out.println("Obitos Acumulados: " + no.dados.obitosAcumulados);
                    System.out.println(contadorPesquisa);
                }

                System.out.println("Pesqusisa na Arvore AVL:");
                no = Floresta[idArvoreAVL].Pesquisa(chaveMenu);
                contadorPesquisa = Floresta[idArvoreAVL].Consultas(chaveMenu);
                Floresta[idArvoreAVL].contadorPesquisa = 1;

                if (no == null)
                    System.out.println("Não encontramos essa folha.");
                else {
                    System.out.println("Casos Acumulados: " + no.dados.casosAcumulados);
                    System.out.println("Obitos Acumulados: " + no.dados.obitosAcumulados);
                    System.out.println(contadorPesquisa);
                }
                MostrarMenu();

                break;
            case 3:
                if (travaOpRegiao++ == 0) {
                    GuardaDadosRegiao();
                }
                opcaoRegiao = Integer.parseInt(JOptionPane
                        .showInputDialog("1 - Norte \n2 - Nordeste \n3 - Sudeste \n4 - Sul \n5 - Centro-Oeste \n0 - Voltar"));
                switch (opcaoRegiao) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Casos totais: " + regiaoBB[0][0]);
                        System.out.println("Obitos totais: " + regiaoBB[0][1]);
                        System.out.println("Numero de comparações BB: " + regiaoBB[0][2]);
                        System.out.println("Numero de comparações AVL: " + regiaoAVL[0][2]);
                        break;
                    case 2:
                        System.out.println("Casos totais: " + regiaoBB[1][0]);
                        System.out.println("Obitos totais: " + regiaoBB[1][1]);
                        System.out.println("Numero de comparações BB: " + regiaoBB[1][2]);
                        System.out.println("Numero de comparações AVL: " + regiaoAVL[1][2]);
                        break;
                    case 3:
                        System.out.println("Casos totais: " + regiaoBB[2][0]);
                        System.out.println("Obitos totais: " + regiaoBB[2][1]);
                        System.out.println("Numero de comparações BB: " + regiaoBB[2][2]);
                        System.out.println("Numero de comparações AVL: " + regiaoAVL[2][2]);
                        break;
                    case 4:
                        System.out.println("Casos totais: " + regiaoBB[3][0]);
                        System.out.println("Obitos totais: " + regiaoBB[3][1]);
                        System.out.println("Numero de comparações BB: " + regiaoBB[3][2]);
                        System.out.println("Numero de comparações AVL: " + regiaoAVL[3][2]);
                        break;
                    case 5:
                        System.out.println("Casos totais: " + regiaoBB[4][0]);
                        System.out.println("Obitos totais: " + regiaoBB[4][1]);
                        System.out.println("Numero de comparações BB: " + regiaoBB[4][2]);
                        System.out.println("Numero de comparações AVL: " + regiaoAVL[4][2]);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        Inicializar();
                        break;
                }
                MostrarMenu();
            case 4:
                break;

            default:
                break;
        }
    }

    private static void CriaFloresta() {
        Floresta[idArvoreBB] = new ArvoreBB();
        Floresta[idArvoreAVL] = new ArvoreAVL();

        System.out.print("\n======== INSERINDO NA ARVORE BINARIA ========\n");
        Floresta[idArvoreBB].raiz = null;
        Floresta[idArvoreBB].InserirBIN(matriz, 0, indiceLinha - 1);

        System.out.print("\n======== INSERINDO NA ARVORE AVL ========\n");
        Floresta[idArvoreAVL].raiz = null;
        Floresta[idArvoreAVL].InserirAVL(matriz, 0, indiceLinha);
    }

    private static void ApagaMatriz() {
        matriz = null;
        System.gc();
    }

    private static void GuardaDadosRegiao() {
        regiaoBB = Arquivo.GuardaRegioes(lastDate, Floresta[idArvoreBB]);
        regiaoAVL = Arquivo.GuardaRegioes(lastDate, Floresta[idArvoreAVL]);
    }
}