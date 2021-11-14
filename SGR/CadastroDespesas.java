package SGR;


import Exceptions.*;
import app.UI;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;



public class CadastroDespesas implements Impressora {

    List<CategoriaDespesa> listaCategoriasDespesas;
    List<SubCategoriaDespesa> listaSubCategoriasDespesas;
    List<Despesa> listaDespesas;
    int mes;
    int ano;

    public void LimpaLista(){
        listaDespesas.clear();
    }

    private float valorTotal() {
        float valorTotal = 0;

        for (Despesa m : listaDespesas) {
            valorTotal += m.getValorDespesa();
        }

        return valorTotal;
    }

    //Solução inicial para escrever despesas
    @Override
    public void escreve(){

        String auxMes = null;
        String strAno = Integer.toString(this.ano);
        if(this.mes == 1 ){
            auxMes = "Jan";
        }
        else if (this.mes == 2 ) {
            auxMes = "Fev";
        }
        else if (this.mes == 3 ) {
            auxMes = "Mar";
        }
        else if (this.mes == 4 ) {
            auxMes = "Abr";
        }
        else if (this.mes == 5 ) {
            auxMes = "Mai";
        }
        else if (this.mes == 6 ) {
            auxMes = "Jun";
        }
        else if (this.mes == 7 ) {
            auxMes = "Jul";
        }
        else if (this.mes == 8) {
            auxMes = "Ago";
        }
        else if (this.mes == 9 ) {
            auxMes = "Set";
        }
        else if (this.mes == 10) {
            auxMes = "Out";
        }
        else if (this.mes == 11) {
            auxMes = "Nov";
        }
        else if (this.mes == 12) {
            auxMes = "Dez";
        }

        String fileName = "despesas_"+ auxMes +"_"+strAno+".txt";
        lerDespesas(this.mes,this.ano);

        BufferedWriter buffer = null;
        FileWriter out = null;
        try {
            out = new FileWriter(fileName);
            buffer = new BufferedWriter(out);

            for (Despesa a : listaDespesas) {
                buffer.write(a.getDescricao().toString());
                buffer.write(';');
                buffer.write(a.getCategoria().toString());
                buffer.write(';');
                String r = Float.toString(a.getValorDespesa());
                buffer.write(r.toString());
                buffer.write('\n');
            }
            buffer.close();
            listaDespesas.clear();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public void lerDespesas(int mes, int ano) {

        this.mes = mes;
        this.ano = ano;
        String strAno = Integer.toString(this.ano);
        String auxMes = null;

        if(this.mes == 1 ){
            auxMes = "Jan";
        }
        else if (this.mes == 2 ) {
            auxMes = "Fev";
        }
        else if (this.mes == 3 ) {
            auxMes = "Mar";
        }
        else if (this.mes == 4 ) {
            auxMes = "Abr";
        }
        else if (this.mes == 5 ) {
            auxMes = "Mai";
        }
        else if (this.mes == 6 ) {
            auxMes = "Jun";
        }
        else if (this.mes == 7 ) {
            auxMes = "Jul";
        }
        else if (this.mes == 8) {
            auxMes = "Ago";
        }
        else if (this.mes == 9 ) {
            auxMes = "Set";
        }
        else if (this.mes == 10) {
            auxMes = "Out";
        }
        else if (this.mes == 11) {
            auxMes = "Nov";
        }
        else if (this.mes == 12) {
            auxMes = "Dez";
        }
        String FileName = "despesas_"+auxMes+"_"+strAno+".txt";


        FileInputStream in = null;  //objeto que "lida" com o arquivo de entrada

        try {

            in = new FileInputStream(FileName); //tenta abrir o arquivo em modo leitura
            //despesas.clear(); //Limpa buffer para evitar duplo cadastro no arquivo

            byte[] conteudoArquivo = in.readAllBytes();
            //Transformar o vetor em uma String!

            String cadastro = "";
            for (int i=0; i<conteudoArquivo.length; i++) {
                cadastro += (char)conteudoArquivo[i];
            }

            String[] strMoradores = cadastro.split("\n");
            for (String par : strMoradores) {
                String[] str = par.split(";");
                String aux1 = str[0];
                String aux2 = str[1];
                float f = Float.parseFloat(str[2]);
                Despesa a = new Despesa(aux1,f,aux2);
                listaDespesas.add(a);
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }


    public CadastroDespesas() {
        listaCategoriasDespesas = new LinkedList<CategoriaDespesa>();
        listaSubCategoriasDespesas = new LinkedList<SubCategoriaDespesa>();
        listaDespesas = new LinkedList<Despesa>();
    }

    public void cadastrarCategoria() {
        Boolean repetir = false;

        do {
            repetir = false;

            try {
                String descricaoCategoria = JOptionPane.showInputDialog("Informe uma descricao para categoria:");

                if (descricaoCategoria.isEmpty()) {
                    throw new CategoriaNaoInformadaException();
                } else {
                    CategoriaDespesa a = new CategoriaDespesa(descricaoCategoria);
                    boolean respostaA = listaCategoriasDespesas.add(a);
                    if (respostaA) {
                        JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
                    }

                }

            } catch (CategoriaNaoInformadaException e) {
                repetir = true;

                String msg = "ERRO! Usuario nao informou uma descricao para categoria: \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }
        } while (repetir);


        System.out.println("Terminou cadastrarCategoria: listaCategoriasDespesas => " + listaCategoriasDespesas);
        return;

    }

    public void cadastrarSubcategoria() {

        Boolean repetir = false;

        do {
            repetir = false;

            try {
                if (listaCategoriasDespesas.isEmpty()) {
                    throw new CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException();


                } else {
                    Object n = (Object)JOptionPane.showInputDialog(null, "Cadastrar uma subcategoria da categoria:","Cadastrar subcategoria", JOptionPane.QUESTION_MESSAGE, null, listaCategoriasDespesas.toArray(), listaCategoriasDespesas.get(0));

                    String descricaoSubCategoria = JOptionPane.showInputDialog("Você está cadastrando uma subcategoria da categoria: " + n + ". \n" + "Agora informe o nome da subcategoria:");

                    int objectIndex = listaCategoriasDespesas.indexOf(n);

                    SubCategoriaDespesa b = new SubCategoriaDespesa(listaCategoriasDespesas.get(objectIndex), descricaoSubCategoria);

                    boolean respostaB = listaSubCategoriasDespesas.add(b);

                    if (respostaB) {
                        JOptionPane.showMessageDialog(null, "Subcategoria cadastrada com sucesso!");
                    }

                }

            } catch (CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException e) {

                String msg = "ERRO! Antes de cadastrar uma subcategoria, voce precisa cadastrar pelo menos uma categoria. \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }

        } while (repetir);


        System.out.println("Terminou cadastrarSubcategoria: listaSubCategoriasDespesas => " + listaSubCategoriasDespesas);
        return;

    }

    //TO-DO cadastrarDespesa
    public void cadastrarDespesa() {

        Boolean repetir = false;
        String mes_Str = "";
        int mes_Int = 0;
        String ano_Str = "";
        int ano_Int = 0;
        String descricao = "";
        String strValor = "";
        float valor_float = 0;
        String categoriaDespesa = "";
        do {
            repetir = false;

            String[] meses = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };


            try {
                mes_Str = (String)JOptionPane.showInputDialog(null, "Escolha o mes referente a despesa","Cadastrar Despesa", JOptionPane.QUESTION_MESSAGE, null, meses, meses[0]);

                if (mes_Str.isEmpty()) {
                    throw new DataInvalidoException();
                } else {
                    mes_Int = Integer.parseInt(mes_Str);
                }

                if (mes_Int < 0 || mes_Int > 12) {
                    throw new DataInvalidoException();
                }
                this.mes = mes_Int;

                ano_Str = JOptionPane.showInputDialog("Informe o ano da Despesa. \nExemplo: 2021 \n");

                if (ano_Str.isEmpty()) {
                    throw new DataInvalidoException();
                } else {
                    ano_Int = Integer.parseInt(ano_Str);
                }
                this.ano = ano_Int;



            } catch (DataInvalidoException e) {
                repetir = true;

                String msg = "ERRO! Data invalida \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }
        } while (repetir);

        //////////////////////      //////////////////////

        do {
            repetir = false;

            List<String> listaCategoriaESubcategorias = new LinkedList<String>();

            for (int i = 0; i < listaCategoriasDespesas.size(); i++) {

                String categoria = listaCategoriasDespesas.get(i).toString();

                listaCategoriaESubcategorias.add(categoria);

            }

            for (int i = 0; i < listaSubCategoriasDespesas.size(); i++) {

                String Subcategoria = listaSubCategoriasDespesas.get(i).toString();

                listaCategoriaESubcategorias.add(Subcategoria);

            }

            try {
                if (listaCategoriasDespesas.isEmpty()) {
                    throw new CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException();

                } else  {
                    categoriaDespesa = (String)JOptionPane.showInputDialog(null, "Escolha a categoria ou subcategoria referente a despesa","Cadastrar Despesa", JOptionPane.QUESTION_MESSAGE, null, listaCategoriaESubcategorias.toArray(), listaCategoriaESubcategorias.get(0));
                }

            } catch (CadastrarSubcategoriaAntesDeCadastrarPeloMenosUmaCategoriaException e) {
                repetir=true;
                String msg = "ERRO! Antes de cadastrar uma despesa, voce precisa cadastrar pelo menos uma categoria. \n";
                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();
                cadastrarCategoria();
            }

        } while (repetir);

        do {
            repetir = false;

            try {
                descricao = JOptionPane.showInputDialog("Descricao da despesa: " + "\n");

                if (descricao.isEmpty()) {

                    throw new DescricaoNaoInformadaException();
                }

            } catch (DescricaoNaoInformadaException e) {
                repetir = true;

                String msg = "ERRO! Descricao da despesa nao informada \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            }
        } while (repetir);


        do {
            repetir = false;

            try {
                strValor = JOptionPane.showInputDialog("Valor: " + "\n");



                if (strValor.isEmpty()) {
                    throw new ValorNaoInformadoException();
                } else {
                    valor_float = Float.parseFloat(strValor);
                }

                if (valor_float < 0) {
                    throw new ValorNegativoException();
                }

            } catch (ValorNaoInformadoException e) {
                repetir = true;

                String msg = "ERRO! Valor da despesa nao informado \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();

            } catch (ValorNegativoException e) {
                repetir = true;

                String msg = "ERRO! Valor da despesa negativo \n";

                JOptionPane.showMessageDialog(null, msg);
                e.printStackTrace();
            }
        } while (repetir);


        // Instanciando Morador
        Despesa despesa = new Despesa(descricao, categoriaDespesa, valor_float, mes_Int, ano_Int);

        boolean respostaC = listaDespesas.add(despesa);
        if (respostaC) {
            JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso!");
        }


        System.out.println("Terminou cadastrarDespesa: listaDespesas => " + listaDespesas);

        return;

    }

    public List<Despesa> getDespesas() {
        return listaDespesas;

    }

    public float getValorTotal() {
        return valorTotal();
    }


}


