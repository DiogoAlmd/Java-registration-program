/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {

    ArrayList<ClienteFisico> clientesFisicos = new ArrayList();
    ArrayList<ClienteJuridico> clientesJuridicos = new ArrayList();
    ArrayList<Produtos> produtos = new ArrayList();
    ArrayList<Fornecedor> fornecedores = new ArrayList();
    ArrayList<Pedido> pedidos = new ArrayList();

    public static void main(String[] args) throws Exception{

        App app = new App();
        boolean continua = true;
        do {
            Scanner scannerString = new Scanner(System.in);

            System.out.println("\n<1> Cadastro de Clientes");
            System.out.println("<2> Cadastro de Fornecedores");
            System.out.println("<3> Cadastro de Produtos");
            System.out.println("<4> Fazer Pedido");
            System.out.println("<5> Baixa de Pagamento de um Pedido");
            System.out.println("<6> Relatório");
            System.out.println("<7> Sair\n");
            System.out.print("Escolha a sua opção: ");

            int opcao = scannerString.nextInt();

            if (opcao < 1 || opcao > 7) {

                //opcao que não existe
                System.out.println("A opção escolhida não existe");

            } else if (opcao == 6) {

                //menu de relatórios
                System.out.println("\n\n\n\n\n\n");
                System.out.println("Digite o relatório desejado \n");
                System.out.println("<1> Listar Clientes");
                System.out.println("<2> Listar Fornecedores");
                System.out.println("<3> Listar Produtos");
                System.out.println("<4> Listar Pedidos");
                System.out.println("<5> Filtrar Pedidos por Data");
                System.out.println("<6> Buscar Pedido pela numeração");
                System.out.println("<7> Listar Pedidos Pagos");
                System.out.println("<8> Buscar Produto pelo nome");
                System.out.println("<9> Valor total de Pedidos em aberto");
                System.out.println("<10> Voltar");

                int subopcao = scannerString.nextInt();

                if (subopcao == 10) {

                    //voltar
                    System.out.println("\n\n\n\n\n\n");
                    continue;

                } else {
                    app.opcaoRelatorio(subopcao);
                }
            } else if (opcao != 7) {

                app.opcaoMenu(opcao);
                continue;
            } else {
                continua = false;
                //fim do programa
            }

        } while (continua == true);
    }

    public void opcaoMenu(int opcao) {

        switch (opcao) {
            case 1:
                cadastroClientes();
                break;
            case 2:
                cadastroFornecedor();
                break;
            case 3:
                cadastroProdutos();
                break;
            case 4:
                fazerPedido();
                break;
            case 5:
                pagaPedido();
                break;
        }
    }

    public void opcaoRelatorio(int opcao) {

        System.out.println("\n\n\n\n\n\n\n\n\n\n");

        switch (opcao) {
            case 1:
                listaClientes();
                break;
            case 2:
                listaFornecedores();
                break;
            case 3:
                listaProdutos();
                break;
            case 4:
                listaPedidos();
                break;
            case 5:
                filtraPedidoData();
                break;
            case 6:
                buscaPedidoID();
                break;
            case 7:
                listaPedidosPagos();
                break;
            case 8:
                buscaProdutoNome ();
                break;
            case 9:
                totalPedidosAberto();
                break;
        }
    }

    public void cadastroClientes() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Digite <1> para Cadastrar Pessoa Física");
        System.out.println("Digite <2> para Cadastrar Pessoa Jurídica");

        Scanner scannerString = new Scanner(System.in);

        String nome = "";
        String email = "";
        String documento = "";
        int pagamento = 0;

        int escolha = scannerString.nextInt();

        if (escolha == 1) {

            //pessoa fisica
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Cadastro de Pessoa Física");
            System.out.println("Digite o nome da pessoa: ");
            nome = scannerString.next();
            System.out.println("Digite o email da pessoa: ");
            email = scannerString.next();
            System.out.println("Digite o CPF da pessoa: ");
            documento = scannerString.next();
            System.out.println("Digite o Máximo de Parcelas permitido ao Cliente: ");
            pagamento = scannerString.nextInt();

            ClienteFisico cliente = new ClienteFisico(nome, email, documento, pagamento);

            //adicioan cliente normal
                clientesFisicos.add(cliente);
                System.out.println("Cliente Adicionado!");

        } else if (escolha == 2) {

            //pessoa juridica
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Cadastro de Pessoa Jurídica");
            System.out.println("Digite o nome da empresa: ");
            nome = scannerString.next();
            System.out.println("Digite o email da empresa: ");
            email = scannerString.next();
            System.out.println("Digite o CNPJ da empresa: ");
            documento = scannerString.next();
            System.out.println("Digite a Quantidade de Dias para o Faturamento: ");
            pagamento = scannerString.nextInt();

            ClienteJuridico cliente = new ClienteJuridico(nome, email, documento, pagamento);

                clientesJuridicos.add(cliente);
                System.out.println("Cliente Adicionado!");


        }

        fim();
    }

    public void cadastroFornecedor() {

        String documento = "";
        String nome = "";
        Scanner scannerString = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Cadastro de Fornecedor");
        System.out.println("Digite o nome do fornecedor: ");
        nome = scannerString.next();
        System.out.println("Digite o CNPJ do fornecedor: ");
        documento = scannerString.next();

        Fornecedor fornecedor = new Fornecedor(nome, documento);
        
            // Cadastra os fornecedores 
            fornecedores.add(fornecedor);
            System.out.println("Fornecedor Adicionado!");

        fim();
    }

    public void cadastroProdutos() {

        String nome = "";
        double preco = 0;
        String descricao = "";
        Scanner scannerString = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Cadastro de Produtos");

        if (fornecedores.size() == 0) {
            System.out.println("Não há fornecedores cadastrados!");
            System.out.println("Registre um fornecedor antes do produto");
            fim();
            return;

        } else {

            System.out.println("Digite o nome do Produto: ");
            nome = scannerString.next();
            System.out.println("Digite o Preço do Produto: ");
            preco = scannerString.nextDouble();
            System.out.println("Digite a descrição do Produto: ");
            descricao = scannerString.next();

            int volta = 2;

            do {
                Scanner scannerStringVolta = new Scanner(System.in);
                String documento = "";
                System.out.println("Digite o CNPJ do Fornecedor: ");
                documento = scannerStringVolta.next();

                Fornecedor fornecedorFinal = new Fornecedor();

                for (Fornecedor fornecedor : fornecedores) {
                    if (fornecedor.getCNPJ().equals(documento)) {
                        fornecedorFinal.copiaFornecedor(fornecedor);
                        break;
                    }
                }

                if (fornecedorFinal.getCNPJ().isEmpty()) {
                    System.out.println("Não foi achado um fornecedor para o cadastro!");
                    System.out.println("Digite 1 para tentar achar um novo fornecedor ou 2 para cancelar o cadastro!");
                    volta = scannerStringVolta.nextInt();
                } else {

                    Produtos produto = new Produtos(nome, preco, descricao, fornecedorFinal);
                    produtos.add(produto);
                    System.out.println("Produto Adicionado!");
                    volta = 2;
                }

            } while (volta != 2);

            fim();

        }
    }

    public void fazerPedido() {

        if (produtos.size() != 0 && (clientesFisicos.size() != 0 || clientesJuridicos.size() != 0)) {
            int id = pedidos.size();

            GregorianCalendar data = new GregorianCalendar();
            int ano = dataAleatoria(2019, 2021);
            data.set(data.YEAR, ano);
            int dia = dataAleatoria(1, data.getActualMaximum(data.DAY_OF_YEAR));
            data.set(data.DAY_OF_YEAR, dia);

            int indiceCliente = -1;
            boolean tipoCliente = false;

            int volta = 2;

            do {
                Scanner scannerString = new Scanner(System.in);
                System.out.println("Digite o documento do cliente (CNPJ/CPF) para iniciar a compra");
                String documento = scannerString.next();

                for (ClienteFisico cliente : clientesFisicos) {
                    if (cliente.getDocumento().equalsIgnoreCase(documento)) {
                        //System.out.println("Achamos o fornecedor");
                        indiceCliente = clientesFisicos.indexOf(cliente);
                        tipoCliente = true;
                        break;
                    }
                }

                if (indiceCliente == -1) {

                    for (ClienteJuridico cliente : clientesJuridicos) {
                        if (cliente.getDocumento().equalsIgnoreCase(documento)) {
                            //System.out.println("Achamos o fornecedor");
                            indiceCliente = clientesJuridicos.indexOf(cliente);
                            tipoCliente = false;
                            break;

                        }
                    }
                }

                if (indiceCliente != -1) {

                    System.out.println("Cliente Localizado!");
                    volta = 2;

                } else {

                    System.out.println("Não foi achado um cliente com o documento informado!");
                    System.out.println("Digite 1 para tentar procurar novamente ou 2 para cancelar o pedido!");
                    volta = scannerString.nextInt();
                    scannerString.close();
                    if (volta == 2) {

                        return;
                    }
                }
                scannerString.close();
            } while (volta != 2);

            Pedido pedido = new Pedido();

            if (tipoCliente) {

                pedido.setPedido(id, data, false, clientesFisicos.get(indiceCliente));

            } else {

                pedido.setPedido(id, data, false, clientesJuridicos.get(indiceCliente));

            }

            volta = 2;

            do {
                Scanner scannerString = new Scanner(System.in);

                System.out.println("Digite o nome do produto que deseja adicionar ao pedido");
                String nomeProduto = scannerString.next();

                Produtos produtoFinal = new Produtos();

                for (Produtos produto : produtos) {
                    if (produto.getNome().equalsIgnoreCase(nomeProduto)) {

                        produtoFinal.copiaProduto(produto);
                        break;
                    }
                }

                if (produtoFinal.getNome().isEmpty()) {
                    System.out.println("Não foi achado um produto com o nome informado!");
                    System.out.println("Digite 1 para tentar procurar novamente ou 2 para cancelar o pedido!");
                    volta = scannerString.nextInt();
                    scannerString.close();
                    if (volta == 2) {
                        return;
                    }
                } else {

                    System.out.println("Digite a quantidade desejada do produto: ");
                    int qtdProduto = scannerString.nextInt();

                    if (qtdProduto < 0) {
                        System.out.println("Quantidade Inválida!");
                        continue;
                    } else {
                        ItemPedido item = new ItemPedido(produtoFinal, qtdProduto);
                        pedido.addItem(item);
                        System.out.println("Produto Adicionado!");
                        System.out.println("Digite 1 adicionar um novo item ou 2 para finalizar o pedido!");
                        volta = scannerString.nextInt();
                    }
                }
            } while (volta != 2);

            pedido.calculaTotal();
            pedidos.add(pedido);
            System.out.println("Pedido Finalizado!");
        } else {
            System.out.println("Não há produtos e/ou clientes cadastrados!");
            System.out.println("Regularize os registros antes de efetuar um pedido");
        }

        fim();
    }

    public int dataAleatoria(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public void pagaPedido() {

        int volta = 2;
        do {
            Scanner scannerString = new Scanner(System.in);
            System.out.println("Digite o id do pedido a ser pago: ");
            int id = scannerString.nextInt();

            boolean vasa = false;

            for (Pedido pedido : pedidos) {
                
                if (pedido.getId() == id) {
                    pedido.setPago(true);
                    vasa = true;
                    break;
                }
            }

            if (vasa) {
                System.out.println("Pedido Pago!");
                volta = 2;
            } else {
                System.out.println("Não foi achado um pedido com o id informado!");
                System.out.println("Digite 1 para tentar procurar novamente ou 2 para cancelar o pedido!");
                volta = scannerString.nextInt();
            }
            scannerString.close();
        } while (volta != 2);

        fim();

    }

    public void listaClientes() {

        System.out.println("Listando todos os clientes");

        boolean verificaClientes = false;

        if (clientesFisicos.size() != 0) {
            System.out.println("Clientes físicos: ");
            for (ClienteFisico cliente : clientesFisicos) {
                cliente.imprimeDados();
                System.out.println("\n");
            }
        } else {
            verificaClientes = true;
        }

        if (clientesJuridicos.size() != 0) {
            System.out.println("Clientes jurídicos: ");
            for (ClienteJuridico cliente : clientesJuridicos) {
                cliente.imprimeDados();
                System.out.println("\n");
            }
        } else {
            if (verificaClientes) {
                System.out.println("Não há Clientes Registrados!");
            }
        }

        fim();

    }

    public void listaFornecedores() {

        System.out.println("Listando todos os Fornecedores");

        if (fornecedores.size() != 0) {
            for (Fornecedor fornecedor : fornecedores) {
                fornecedor.imprimeDados();
                System.out.println("\n");
            }
        } else {
            System.out.println("Não há Fornecedores Registrados!");
        }

        fim();
    }

    public void listaProdutos() {

        System.out.println("Listando todos os Produtos");

        if (produtos.size() != 0) {
            for (Produtos produto : produtos) {
                produto.imprimeDados();
                System.out.println("\n");
            }
        } else {
            System.out.println("Não há Produtos Registrados!");
        }

        fim();
    }

    public void listaPedidos() {

        System.out.println("Listando todos os Pedidos");

        if (pedidos.size() != 0) {
            for (Pedido pedido : pedidos) {
                pedido.imprimeDados();
                System.out.println("\n");
            }
        } else {
            System.out.println("Não há Pedidos Registrados!");
        }

        fim();
    }

    public void filtraPedidoData() {

        Scanner scannerString = new Scanner(System.in);
        System.out.println("Filtrar Pedidos por Data (formato XX/XX/XXXX)");
        System.out.println("Digite a data de inicio: ");
        String comeco = scannerString.next();
        System.out.println("Digite a data de termino: ");
        String fim = scannerString.next();
        
        scannerString.close();

        GregorianCalendar dataInicio = new GregorianCalendar();
        GregorianCalendar dataFim = new GregorianCalendar();
        dataInicio = converteData(comeco);
        dataFim = converteData(fim);

        boolean vasa = false;
        for (Pedido pedido : pedidos) {
            if (calculaDist(dataInicio, pedido.getData()) >= 0 && calculaDist(pedido.getData(), dataFim) >= 0 ) {
                pedido.imprimeDados();
                vasa = true;
                break;
            }
        }
        
        if (!vasa) {
            System.out.println("Não foi achado um pedido no periodo informado!");
        }
        
        fim();
    }
    
    public GregorianCalendar converteData(String data){
        
        int dia = Integer.parseInt(data.substring(0, data.indexOf("/")));
        int mes = Integer.parseInt(data.substring(data.indexOf("/")+1, data.lastIndexOf("/")));
        mes --;
        int ano = Integer.parseInt(data.substring(data.lastIndexOf("/")+1, data.length()));
        
        GregorianCalendar dataFinal = new GregorianCalendar();
        
        dataFinal.set(ano, mes, dia);
        return dataFinal;
    }
    
    public  int  calculaDist (GregorianCalendar data1, GregorianCalendar data2){

        int dias = data2.get(data2.DAY_OF_YEAR) - data1.get(data1.DAY_OF_YEAR);
        return dias;
    }

    public void buscaPedidoID() {
        
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Digite o id do pedido a ser pesquisado: ");
        int id = scannerString.nextInt();
        scannerString.close();
        boolean vasa = false;

        for (Pedido pedido : pedidos) {

            if (pedido.getId() == id) {
                pedido.imprimeDadosDatelhados();
                vasa = true;
                break;
            }
        }

        if (!vasa) {

            System.out.println("Não foi achado um pedido com o id informado!");
        }
        
        fim();
    }
    
    public void listaPedidosPagos (){
        
        boolean vasa = false;
        System.out.println("Listando pedidos pagos");

        for (Pedido pedido : pedidos) {
            if (pedido.isPago()) {
                pedido.imprimeDados();
                vasa = true;
                break;
            }
        }

        if (!vasa) {

            System.out.println("Não foi achado nenhum pedido pago!");
        }
        
        fim();
    }
    
    public void buscaProdutoNome (){
        
        Scanner scannerString = new Scanner(System.in);

        System.out.println("Digite o nome do produto que deseja consultar");
        String nomeProduto = scannerString.next();
        
        scannerString.close();
        boolean vasa = false;
        for (Produtos produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produto.imprimeDados();
                vasa = true;
                break;
            }
        }
        
        if (!vasa) {

            System.out.println("Não foi achado nenhum produto com este nome!");
        }
        
        fim();
    }
    
    public void totalPedidosAberto(){
        
        System.out.println("Listando pedidos em aberto");
        
        boolean vasa = false;
        double total = 0;

        for (Pedido pedido : pedidos) {

            if (!pedido.isPago()) {
                pedido.imprimeDados();
                total += pedido.getTotal();
                vasa = true;
                break;
            }
        }

        if (!vasa) {

            System.out.println("Não foi achado nenhum pedido em aberto!");
        }
        else {

            NumberFormat formatter = NumberFormat.getCurrencyInstance(); 
            System.out.println("\n\n Vzlor Total dos pedidos em aberto: " + formatter.format(total));
        }
        
        fim();
        
    }

    public void fim() {

        System.out.println("Pressione qualquer tecla pra voltar");

        try {
            System.in.read();
        } catch (Exception e) {
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}
